package cn.cxnxs.bookmark.service;


/**
 * 系统服务
 *
 * @author mengjinyuan
 */
public interface SystemService {

    /**
     * 保存访问历史
     *
     * @param url
     */
    void saveHistory(String url);
}
