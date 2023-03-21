package cn.cxnxs.bookmark.vo.request;

import cn.cxnxs.common.core.entity.request.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>文件夹入参</p>
 *
 * @author mengjinyuan
 * @date 2022-02-18 11:10
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class FolderVo extends BaseVo {
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

    private Integer sortNo;
}
