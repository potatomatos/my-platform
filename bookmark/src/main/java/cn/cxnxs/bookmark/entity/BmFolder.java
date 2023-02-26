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
 * 文件夹
 * </p>
 *
 * @author mengjinyuan
 * @since 2022-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BmFolder extends Model<BmFolder> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文件夹名称
     */
    private String folderName;

    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 所属用户
     */
    private Integer userId;

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
