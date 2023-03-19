package cn.cxnxs.common.core.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class UserInfo {
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
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
