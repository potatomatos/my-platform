package cn.cxnxs.common.api.system.domain;

import cn.cxnxs.common.core.entity.TreeVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
public class UserApiEntity {

    private Integer id;

    private String username;

    private String realName;

    private String encryptedPassword;

    /**
     * 头像
     */
    private String avatar;

    private String phoneNumber;

    private String email;

    private String resetPasswordToken;

    private LocalDateTime resetPasswordSentTime;

    private Integer loginCount;

    private LocalDateTime currentLoginTime;

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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer draw;

    private List<String> userClients;

    private List<String> userRoles;

    private List<TreeVo> userMenus;

    private List<String> userMenuPaths;

    private List<Map<String, String>> permissions;

    public String getStateStr() {
        String stateStr = "";
        if (state != null) {
            if (0 == this.state) {
                stateStr = "启用";
            }
            if (1 == this.state) {
                stateStr = "停用";
            }
            if (2 == this.state) {
                stateStr = "账号过期";
            }
            if (3 == this.state) {
                stateStr = "认证过期";
            }
            if (4 == this.state) {
                stateStr = "账号锁定";
            }
        }
        return stateStr;
    }

}
