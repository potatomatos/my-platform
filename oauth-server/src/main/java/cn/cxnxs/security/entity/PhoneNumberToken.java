package cn.cxnxs.security.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

@Getter
@Setter
public class PhoneNumberToken extends AbstractAuthenticationToken {

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 短信验证码
     */
    private String verificationCode;

    /**
     * 用户信息
     */
    private JwtUser jwtUser;

    public PhoneNumberToken() {
        super(null);
        super.setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.jwtUser;
    }
}
