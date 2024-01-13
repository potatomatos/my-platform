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
 * 最近访问记录
 * </p>
 *
 * @author mengjinyuan
 * @since 2022-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BmRecentVisited extends Model<BmRecentVisited> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 书签id
     */
    private Integer bookmarkId;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 创建时间
     */
    private Long accessTime;

    /**
     * 访问次数
     */
    private Integer accessCount;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
