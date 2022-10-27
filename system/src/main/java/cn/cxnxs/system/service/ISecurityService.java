package cn.cxnxs.system.service;

import cn.cxnxs.system.security.entity.JwtUser;
import cn.cxnxs.system.security.entity.UserPasswordAuthenticationToken;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-05-04 15:35
 **/
public interface ISecurityService {

    /**
     * 获取验证码
     * @return
     */
    ByteArrayOutputStream getCaptcha();

    /**
     * 系统用户名密码登录
     * @param userPasswordAuthenticationToken
     * @return
     */
    JwtUser login(UserPasswordAuthenticationToken userPasswordAuthenticationToken);

    /**
     * 判断是否是允许通过的资源
     * @param uri
     * @param clientId
     * @return
     */
    boolean permit(String uri,String clientId);

    /**
     * 获取白名单地址（不拦截的）
     * @return
     */
    List<String> permitPermissions(String clientId);
}
