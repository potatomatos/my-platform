package cn.cxnxs.bookmark.vo.response;

import cn.cxnxs.common.core.entity.request.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-04-05 17:20
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class CheckRespVo extends BaseVo {

    /**
     * 是否存在
     */
    private Boolean exist = false;

    /**
     * 存在的路径
     */
    private List<String> path=new ArrayList<>();

    /**
     * 所在文件夹
     */
    private Integer folderId;

    private Integer id;

}
