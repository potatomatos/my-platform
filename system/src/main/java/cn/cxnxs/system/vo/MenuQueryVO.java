package cn.cxnxs.system.vo;

import cn.cxnxs.common.core.entity.request.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MenuQueryVO extends BaseVo {

    private String menuName;

    private Integer id;

    private Integer pid;

    private String url;
}
