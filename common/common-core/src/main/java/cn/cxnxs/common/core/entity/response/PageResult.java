package cn.cxnxs.common.core.entity.response;

import java.util.List;

/**
 * <p>分页结果对象</p>
 *
 * @author mengjinyuan
 * @date 2020-12-09 14:03
 **/
public class PageResult<T> extends Result<T> {
    /**
     * 数据总数
     */
    private Long count;

    private List<T> rows;

    public PageResult(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "count=" + count +
                ", rows=" + rows +
                '}';
    }
}
