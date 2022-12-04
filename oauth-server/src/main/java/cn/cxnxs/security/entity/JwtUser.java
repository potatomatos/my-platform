package cn.cxnxs.security.entity;

import cn.cxnxs.common.core.entity.TreeVo;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

/**
 * <p>用户信息</p>
 *
 * @author mengjinyuan
 * @date 2022-04-10 23:11
 **/
@Getter
@Setter
public class JwtUser implements UserDetails {

    private Integer id;
    private String username;
    @JSONField(serialize = false)
    private String password;

    private String realName;
    /**
     * 头像
     */
    private String avatar;
    private String phoneNumber;
    private String email;

    private Integer loginCount;
    private String currentLoginIp;

    private List<String> userClients;
    private List<String> userRoles;
    private List<Map<String, String>> permissions;
    private List<TreeVo> userMenus;
    private List<String> userMenuPaths;
    private Map<String, List<Map<String, String>>> rolePermissions;

    private List<GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    /**
     * 用户状态
     */
    public enum USER_STATE {
        ENABLED(0, "启用"),
        DISABLED(1, "禁用"),
        ACCOUNT_EXPIRED(2, "账号过期"),
        CREDENTIALS_EXPIRED(3, "密码过期"),
        ACCOUNT_LOCKED(4, "账号锁定"),
        DELETED(5, "账号已删除");
        /**
         * 码值
         */
        final private Integer code;

        /**
         * 描述
         */
        final private String desc;

        USER_STATE(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public Integer getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public String getDescByCode(Integer code) {
            for (USER_STATE userState : USER_STATE.values()) {
                if (userState.getCode().equals(code)) {
                    return userState.getDesc();
                }
            }
            return "";
        }
    }
}
