package cn.cxnxs.system.service;

import java.util.List;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-05-04 15:35
 **/
public interface IPermissionService {


    /**
     * 判断是否是允许通过的资源
     * @param uri
     * @param clientId
     * @return
     */
    boolean permit(String uri,String clientId);

    /**
     * 获取白名单地址（不拦截的）
     * @return
     */
    List<String> permitPermissions(String clientId);
}
