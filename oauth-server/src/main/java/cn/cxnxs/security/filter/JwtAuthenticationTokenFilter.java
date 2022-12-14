package cn.cxnxs.security.filter;

import cn.cxnxs.common.cache.RedisUtils;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.security.entity.JwtUser;
import cn.cxnxs.security.entity.UserPasswordAuthenticationToken;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
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
    private TokenStore jdbcTokenStore;

    @Autowired
    private RedisUtils redisUtils;

    private static final String REDIS_KEY = "USER_INFO:";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        List<AntPathRequestMatcher> list = Lists.newArrayList();
        list.add(new AntPathRequestMatcher("/oauth/**"));
        list.add(new AntPathRequestMatcher("/captcha"));
        list.add(new AntPathRequestMatcher("/rsa/publicKey"));
        list.add(new AntPathRequestMatcher("/login"));
        boolean match = false;
        for (AntPathRequestMatcher ant : list) {
            if (ant.matches(request)) {
                match = true;
            }
        }
        if (!match) {
            //1???????????????????????????token
            String accessToken = request.getHeader("access_token");
            //header??????????????????????????????
            if (StringUtils.isEmpty(accessToken)) {
                accessToken = request.getParameter("access_token");
            }

            if (!StringUtils.hasText(accessToken)) {
                render(request, response, Result.failure(Result.ResultEnum.NEED_LOGIN, null));
                return;
            }
            String key=REDIS_KEY + accessToken;
            try {
                UserPasswordAuthenticationToken passwordAuthenticationToken;
                if (redisUtils.hasKey(key)) {
                    passwordAuthenticationToken= redisUtils.get(key);
                }else {
                    OAuth2Authentication oAuth2Authentication = jdbcTokenStore.readAuthentication(accessToken);
                    if (Objects.isNull(oAuth2Authentication)) {
                        render(request, response, Result.failure(Result.ResultEnum.TOKEN_REQUIRED, null));
                        return;
                    }
                    passwordAuthenticationToken = (UserPasswordAuthenticationToken) oAuth2Authentication.getUserAuthentication();
                    redisUtils.set(REDIS_KEY + accessToken,passwordAuthenticationToken,3600);
                }
                SecurityContextHolder.getContext().setAuthentication(passwordAuthenticationToken);

                OAuth2AccessToken oAuth2AccessToken = jdbcTokenStore.readAccessToken(accessToken);
                if (oAuth2AccessToken.isExpired()) {
                    //token??????
                    render(request, response, Result.failure(Result.ResultEnum.TOKEN_EXPIRED, null));
                    return;
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                //token??????????????????
                render(request, response, Result.failure(Result.ResultEnum.NEED_LOGIN, e.getMessage()));
                return;
            }
        }
        //??????
        filterChain.doFilter(request, response);
    }

    /**
     * ????????????
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
