package cn.cxnxs.bookmark.vo.request;

import cn.cxnxs.common.core.entity.request.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>url检测实体返回</p>
 *
 * @author mengjinyuan
 * @date 2022-04-02 00:09
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class CheckVo extends BaseVo {

    private Integer id;

    private Integer total;

    private Integer invalidDataCount;

    private Integer checkedCount;

    private String title;

    private String url;

    private Integer statusCode;

    /**
     * 是否有效
     */
    private Boolean valid = true;

    public CheckVo() {
    }

    public CheckVo(Integer total, Integer invalidDataCount, Integer checkedCount) {
        this.total = total;
        this.invalidDataCount = invalidDataCount;
        this.checkedCount = checkedCount;
    }
}
