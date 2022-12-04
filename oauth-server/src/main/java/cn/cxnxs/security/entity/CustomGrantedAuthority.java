package cn.cxnxs.security.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-12-04 22:34
 **/
public class CustomGrantedAuthority implements GrantedAuthority {

    private String role;

    public CustomGrantedAuthority() {
    }

    public CustomGrantedAuthority(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}
