package cn.cxnxs.system.vo;

import cn.cxnxs.common.core.entity.TreeVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-10-26 22:50
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class DictVO extends TreeVo {

    private Integer id;
    private String dictType;
    private String code;
    private String label;
    private Integer state;
    private Integer sort;
    private Long createdAt;
    private Long updatedAt;
}
