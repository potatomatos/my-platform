package cn.cxnxs.system.vo;


import lombok.Data;

@Data
public class MenuVO {

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
}
