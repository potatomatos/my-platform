package cn.cxnxs.security.filter;

import cn.cxnxs.common.web.vo.response.Result;
import cn.cxnxs.security.entity.JwtUser;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-05-07 23:07
 **/
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private TokenStore jdbcTokenStore;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String uri = request.getRequestURI();

        String clientId = request.getHeader("clientId");

        //不需要token的路由可以直接放行
        if (securityService.permit(uri, clientId)) {
            filterChain.doFilter(request, response);
            return;
        }
        //1、获取请求头携带的token
        String accessToken = request.getHeader("access_token");
        //header中没有就从参数中获取
        if (StringUtils.isEmpty(accessToken)) {
            accessToken = request.getParameter("access_token");
        }

        if (!StringUtils.hasText(accessToken)) {
            render(request, response, Result.failure(Result.ResultEnum.NEED_LOGIN, null));
            return;
        }

        //2、解析出userId
        JwtUser jwtUser;
        try {
            OAuth2Authentication oAuth2Authentication = jdbcTokenStore.readAuthentication(accessToken);
            if (Objects.isNull(oAuth2Authentication)) {
                render(request, response, Result.failure(Result.ResultEnum.TOKEN_REQUIRED, null));
                return;
            }
            OAuth2AccessToken oAuth2AccessToken = jdbcTokenStore.readAccessToken(accessToken);
            if (oAuth2AccessToken.isExpired()) {
                //token过期
                render(request, response, Result.failure(Result.ResultEnum.TOKEN_EXPIRED, null));
                return;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //token超时或者非法
            render(request, response, Result.failure(Result.ResultEnum.NEED_LOGIN, e.getMessage()));
            return;
        }
        //放行
        filterChain.doFilter(request, response);
    }

    /**
     * 渲染视图
     *
     * @param request
     * @param response
     */
    private void render(HttpServletRequest request, HttpServletResponse response, Object data) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        if (request.getHeader("x-requested-with") != null
                && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with"))) {
            response.setHeader("Content-Type", "application/json");
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.getWriter().write(JSONObject.toJSONString(data));
        }
    }
}
