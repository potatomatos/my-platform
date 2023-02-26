package cn.cxnxs.bookmark.vo.request;

import cn.cxnxs.common.core.entity.request.BaseVo;
import lombok.Data;

/**
 * <p>移动收藏夹实体</p>
 *
 * @author mengjinyuan
 * @date 2022-04-05 11:14
 **/
@Data
public class MoveVo extends BaseVo {

    /**
     * id
     */
    private Integer id;

    /**
     * 类型
     */
    private Integer type;

    public static final Integer TYPE_FOLDER=1;

    public static final Integer TYPE_BOOKMARK=2;

}
