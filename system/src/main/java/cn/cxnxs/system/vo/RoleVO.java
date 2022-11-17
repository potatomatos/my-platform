package cn.cxnxs.system.vo;

import lombok.Data;

import java.util.List;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-05-15 21:49
 **/
@Data
public class RoleVO {

    private Integer id;

    private Integer userId;

    private String roleName;

    /**
     * 角色代码
     */
    private String roleCode;

    /**
     * 所属应用
     */
    private String clientId;

    /**
     * 应用名
     */
    private String appName;

    /**
     * 描述
     */
    private String description;

    private Long createdAt;

    private Long updatedAt;

    private Integer draw;

    private List<Integer> menuIds;
}
