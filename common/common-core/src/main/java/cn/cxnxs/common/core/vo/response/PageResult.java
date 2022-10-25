package cn.cxnxs.common.core.vo.response;

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

    public PageResult(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "count=" + count +
                "} " + super.toString();
    }
}
