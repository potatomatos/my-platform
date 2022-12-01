package cn.cxnxs.system.vo;


import cn.cxnxs.common.core.entity.TreeVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MenuVO extends TreeVo {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 父id
     */
    private Integer parentId;

    private MenuVO parent;

    /**
     * 路由 path
     */
    private String path;

    private String url;

    /**
     * 菜单名称
     */
    private String title;

    private String menuName;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * SVG 菜单图标
     */
    private String iconSvg;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态
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
     * 菜单排序
     */
    private Integer sortNo;

}
