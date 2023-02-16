package cn.cxnxs.security.handler;

import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.security.config.JSONAuthentication;
import cn.cxnxs.security.constants.RedisKeyPrefix;
import cn.cxnxs.security.entity.JwtUser;
import cn.cxnxs.security.entity.UserPasswordAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * <p>登出处理器</p>
 *
 * @author mengjinyuan
 * @date 2022-04-14 09:59
 **/
@Component("myLogoutHandler")
public class LogoutHandler extends JSONAuthentication implements LogoutSuccessHandler {

    @Autowired
    private TokenStore jdbcTokenStore;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        //删除token信息
        String accessToken = httpServletRequest.getHeader("access_token");
        OAuth2AccessToken oAuth2AccessToken = jdbcTokenStore.readAccessToken(accessToken);
        OAuth2Authentication oAuth2Authentication = jdbcTokenStore.readAuthentication(accessToken);
        UserPasswordAuthenticationToken userAuthentication = (UserPasswordAuthenticationToken) oAuth2Authentication.getUserAuthentication();
        if (!Objects.isNull(oAuth2AccessToken)){
            jdbcTokenStore.removeAccessToken(oAuth2AccessToken);
        }
        //删除缓存信息
        JwtUser jwtUser = userAuthentication.getJwtUser();
        redisTemplate.delete(RedisKeyPrefix.KEY_USER_INFO+jwtUser.getId());
        Result<String> result = Result.success("注销成功");
        this.writeJSON(httpServletRequest,httpServletResponse,result);
    }
}
