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
        return (PhoneNumberToken.class.isAssignableFrom(aClass));
    }
}
