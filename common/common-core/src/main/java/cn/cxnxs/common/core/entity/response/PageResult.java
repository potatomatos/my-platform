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

    private Integer pageSize;

    private Integer pages;

    private Integer current;

    private List<T> rows;

    public PageResult() {
    }

    public PageResult(Long count) {
        this.count = count;
    }

    public PageResult(Integer pageNo, Integer pageSize) {
        this.current = pageNo;
        this.pageSize = pageSize;
    }

    public PageResult(Integer pageNo, Integer pageSize, Long count) {
        this.current = pageNo;
        this.pageSize = pageSize;
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

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "count=" + count +
                ", pageSize=" + pageSize +
                ", pages=" + pages +
                ", current=" + current +
                ", rows=" + rows +
                '}';
    }
}
