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
public class UserVO{

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


    public String getStateStr(){
        String stateStr="";
        if (state!=null){
            if (0==this.state){
                stateStr="启用";
            }
            if (1==this.state){
                stateStr="停用";
            }
            if (2==this.state){
                stateStr="账号过期";
            }
            if (3==this.state){
                stateStr="认证过期";
            }
            if (4==this.state){
                stateStr="账号锁定";
            }
        }
        return stateStr;
    }

}
