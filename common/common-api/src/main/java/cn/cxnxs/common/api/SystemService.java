package cn.cxnxs.common.api;

import cn.cxnxs.common.api.constants.ServiceNameConstants;
import cn.cxnxs.common.api.domain.UserApiEntity;
import cn.cxnxs.common.api.factory.SystemServiceFallbackFactory;
import cn.cxnxs.common.core.entity.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 系统服务应用
 *
 * @author mengjinyuan
 */
@FeignClient(value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = SystemServiceFallbackFactory.class)
public interface SystemService {

    /**
     * 获取放行的路径
     * @param uri 地址
     * @param clientId 客户端id
     * @return true or false
     */
    @GetMapping(value = "/system/api/permit")
    Result<Boolean> permit(@RequestParam("uri") String uri, @RequestParam("clientId") String clientId);

    /**
     * 更新用户信息
     * @param userApiEntity 用户信息
     * @return true-成功 false-失败
     */
    @PostMapping("/system/api/updateUser")
    Result<Boolean> updateUser(@RequestBody UserApiEntity userApiEntity);

    @GetMapping("/system/api/getUserByName")
    Result<UserApiEntity> getUserByName(@RequestParam("username") String username);
}
