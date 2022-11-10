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

    private Integer state;
}
