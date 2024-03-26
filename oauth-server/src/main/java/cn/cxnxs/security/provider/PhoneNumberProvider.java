package cn.cxnxs.security.provider;

import cn.cxnxs.security.entity.PhoneNumberToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * 短信登录处理器
 */
@Slf4j
public class PhoneNumberProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        //Manager传递token给provider，调用本方法判断该provider是否支持该token。不支持则尝试下一个filter
        //本类支持的token类：UserPasswordAuthenticationToken
        return (PhoneNumberToken.class.isAssignableFrom(aClass));
    }
}
