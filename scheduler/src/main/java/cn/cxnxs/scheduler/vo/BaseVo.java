package cn.cxnxs.scheduler.vo;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * <p>基础vo</p>
 *
 * @author mengjinyuan
 * @date 2020-11-25 14:18
 **/
public abstract class BaseVo implements Serializable {

    private Long page;

    private Long limit;

    private String token;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 转成json
     *
     * @return json字符串
     */
    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}
