package cn.cxnxs.bookmark.vo.request;

import cn.cxnxs.common.core.entity.request.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>书签</p>
 *
 * @author mengjinyuan
 * @date 2022-02-18 10:58
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class BookmarkVo extends BaseVo {

    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 地址
     */
    private String url;

    /**
     * 图标地址
     */
    private String iconUrl;


    /**
     * 所属文件夹
     */
    private Integer folderId;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 特别收藏标识，0-否，1是
     */
    private Integer favoriteFlg;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 是否有效，0是 1否
     */
    private Integer state;

}
