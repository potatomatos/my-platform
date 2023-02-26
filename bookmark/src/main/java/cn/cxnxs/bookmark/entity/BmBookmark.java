package cn.cxnxs.bookmark.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 书签
 * </p>
 *
 * @author mengjinyuan
 * @since 2022-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BmBookmark extends Model<BmBookmark> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
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
     * 是否有效，0是 1否
     */
    private Integer state;

    /**
     * 所属文件夹
     */
    private Integer folderId;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 特别收藏标识，0-是，1否
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
     * 排序
     */
    private Integer sortNo;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
