package cn.cxnxs.system.vo;


import lombok.Data;

@Data
public class MenuVO {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 路由 path
     */
    private String path;
    /**
     * 菜单名称
     */
    private String title;

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

}
