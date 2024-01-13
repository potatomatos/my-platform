package cn.cxnxs.system.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author mengjinyuan
 * @since 2022-05-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermission extends Model<SysPermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 接口名称
     */
    private String apiName;

    /**
     * 接口地址
     */
    private String api;

    /**
     * 编码
     */
    private String code;

    /**
     * 所属菜单
     */
    private Integer menuId;

    /**
     * 所属应用
     */
    private String clientId;

    /**
     * 状态：0启用，1禁用
     */
    private Integer state;

    /**
     * 接口描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Long createdAt;

    /**
     * 更新时间
     */
    private Long updateAt;

    /**
     * 权限类型：0常规，1白名单
     */
    private Integer permissionType;


    @Override
    public Serializable pkVal() {
        return null;
    }

}
