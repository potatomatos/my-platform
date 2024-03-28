package cn.cxnxs.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author mengjinyuan
 * @since 2022-05-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserVO {

    private Integer id;

    private String username;

    private String realName;

    private String password;

    /**
     * 头像
     */
    private String avatar;

    private String phoneNumber;

    private String email;

    private String resetPasswordToken;

    private LocalDateTime resetPasswordSentTime;

    private Integer loginCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime currentLoginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime lastLoginTime;

    private String currentLoginIp;

    private String lastLoginIp;

    private Integer failedAttempts;

    private String unlockToken;

    private LocalDateTime lockedTime;

    private String confirmationToken;

    private LocalDateTime confirmedTime;

    private LocalDateTime confirmationSentTime;

    private String unconfirmedEmail;

    private String userType;

    /**
     * 0-启用 1-停用 2-账号过期 3-认证过期 4-账号锁定
     */
    private Integer state;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer draw;

    /**
     * 用户角色
     */
    private List<RoleVO> userRoles;

    private List<Integer> roleIds;

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

        public static String getDescByCode(Integer code) {
            for (USER_STATE userState : USER_STATE.values()) {
                if (userState.getCode().equals(code)) {
                    return userState.getDesc();
                }
            }
            return "";
        }
    }

    public String getStateStr() {
        return USER_STATE.getDescByCode(this.state);
    }

}
