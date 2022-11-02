package cn.cxnxs.security.provider;

import cn.cxnxs.common.api.SystemService;
import cn.cxnxs.common.api.domain.UserApiEntity;
import cn.cxnxs.common.cache.RedisUtils;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.security.constants.RedisKeyPrefix;
import cn.cxnxs.security.entity.JwtUser;
import cn.cxnxs.security.entity.UserPasswordAuthenticationToken;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-05-06 22:44
 **/
@Slf4j
public class UserPasswordAuthorizationProvider implements AuthenticationProvider {

    @Autowired
    private SystemService systemService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * 在此方法进行认证
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //认证代码，认证通过返回认证对象，失败返回null
        UserPasswordAuthenticationToken userPasswordAuthenticationToken = (UserPasswordAuthenticationToken) authentication;
        if (userPasswordAuthenticationToken.getUsername() == null || userPasswordAuthenticationToken.getPassword() == null) {
            return null;
        }
        JwtUser user = this.login(userPasswordAuthenticationToken);
        //返回认证后的Token
        userPasswordAuthenticationToken.setJwtUser(user);
        userPasswordAuthenticationToken.setAuthenticated(true);
        return userPasswordAuthenticationToken;
    }


    /**
     * 系统用户名密码登录
     *
     * @param userPasswordAuthenticationToken 登录信息
     * @return
     */
    private JwtUser login(UserPasswordAuthenticationToken userPasswordAuthenticationToken) {
        //判空
        if (StringUtil.isEmpty(userPasswordAuthenticationToken.getUsername())) {
            throw new AuthenticationServiceException("用户名为空");
        }
        if (StringUtil.isEmpty(userPasswordAuthenticationToken.getPassword())) {
            throw new AuthenticationServiceException("密码为空");
        }
        if (StringUtil.isEmpty(userPasswordAuthenticationToken.getCaptcha())) {
            throw new AuthenticationServiceException("验证码为空");
        }
        if (StringUtil.isEmpty(userPasswordAuthenticationToken.getClientId())) {
            throw new AuthenticationServiceException("clientId为空");
        }
        if (StringUtil.isEmpty(userPasswordAuthenticationToken.getRedirectUri())) {
            throw new AuthenticationServiceException("回调地址为空");
        }
        //获取验证码
        String key = RedisKeyPrefix.KEY_CAPTCHA + this.getIpAddr();
        String captcha = redisUtils.get(key);
        if (!userPasswordAuthenticationToken.getCaptcha().equalsIgnoreCase(captcha)) {
            throw new AuthenticationServiceException("验证码错误");
        }
        //查询用户信息
        JwtUser userDetails = (JwtUser) userDetailService.loadUserByUsername(userPasswordAuthenticationToken.getUsername());
        //判断密码
        if (!passwordEncoder.matches(userPasswordAuthenticationToken.getPassword(), userDetails.getPassword())) {
            throw new BadCredentialsException("密码错误");
        }
        //将用户信息保存到redis
        redisTemplate.opsForValue().set(RedisKeyPrefix.KEY_USER_INFO + userDetails.getId(), JSON.toJSONString(userDetails));
        //删除验证码
        redisTemplate.delete(key);
        //更新用户信息
        UserApiEntity userApiEntity = new UserApiEntity();
        userApiEntity.setId(userDetails.getId());
        userApiEntity.setLoginCount(userDetails.getLoginCount() + 1);
        userApiEntity.setCurrentLoginTime(LocalDateTime.now());
        userApiEntity.setLastLoginTime(userDetails.getCurrentLoginTime());
        userApiEntity.setCurrentLoginIp(getIpAddr());
        userApiEntity.setLastLoginIp(userDetails.getCurrentLoginIp());
        systemService.updateUser(userApiEntity);
        userPasswordAuthenticationToken.setJwtUser(userDetails);
        //存入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(userPasswordAuthenticationToken);
        return userDetails;
    }


    /**
     * 获取客户端ip
     *
     * @return
     */
    private String getIpAddr() {
        String ipAddress;
        try {
            ipAddress = httpServletRequest.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = httpServletRequest.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = httpServletRequest.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = httpServletRequest.getRemoteAddr();
                String localhost = "127.0.0.1";
                if (localhost.equals(ipAddress)) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet;
                    try {
                        inet = InetAddress.getLocalHost();
                        ipAddress = inet.getHostAddress();
                    } catch (UnknownHostException e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) {
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            ipAddress = "";
        }
        return "0:0:0:0:0:0:0:1".equals(ipAddress) ? "127.0.0.1" : ipAddress;
    }

    /**
     * 此方法决定Provider能够处理哪些Token，此Provider只能处理密码登录方式的Token，这里也是多种登录方式的核心
     *
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        //Manager传递token给provider，调用本方法判断该provider是否支持该token。不支持则尝试下一个filter
        //本类支持的token类：UserPasswordAuthenticationToken
        return (UserPasswordAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
