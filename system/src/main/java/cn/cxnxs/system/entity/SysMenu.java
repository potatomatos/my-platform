package cn.cxnxs.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author mengjinyuan
 * @since 2022-05-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 所属应用
     */
    private String clientId;

    /**
     * 菜单标题
     */
    private String menuName;

    /**
     * 路径
     */
    private String url;

    /**
     * 菜单排序
     */
    private Integer sortNo;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * svg图标
     */
    private String iconSvg;

    /**
     * 描述
     */
    private String description;

    /**
     * 权限状态(0无效1有效)
     */
    private Integer state;

    /**
     * 是否鉴权
     */
    private Integer auth;

    /**
     * 是否展示
     */
    private Integer hide;

    /**
     * 页面缓存
     */
    private Integer cache;

    /**
     * 重定向地址
     */
    private String redirect;

    /**
     * 组件地址
     */
    private String component;

    /**
     * 路由名称
     */
    private String routeName;

    /**
     * 权限标志
     */
    private String permission;


    /**
     * 右上角标记
     */
    private String badgeUrl;

    /**
     * 创建时间
     */
    private Long createdAt;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
