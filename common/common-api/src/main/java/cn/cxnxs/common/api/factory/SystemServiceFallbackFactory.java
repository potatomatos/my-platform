package cn.cxnxs.common.api.factory;


import cn.cxnxs.common.api.SystemService;
import cn.cxnxs.common.api.domain.UserApiEntity;
import cn.cxnxs.common.core.entity.response.Result;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * 服务降级
 */
@Slf4j
@Component
public class SystemServiceFallbackFactory implements FallbackFactory<SystemService> {

    @Override
    public SystemService create(Throwable throwable) {

        return new SystemService() {
            @Override
            public Result<Boolean> permit(String uri, String clientId) {
                log.error("获取白名单失败！");
                return Result.failure("获取白名单失败！");
            }

            @Override
            public Result<Boolean> updateUser(UserApiEntity userApiEntity) {
                log.error("用户信息更新失败！");
                return Result.failure("用户信息更新失败！");
            }

            @Override
            public Result<UserApiEntity> getUserByName(String username) {
                log.error("用户信息更新失败！");
                return Result.failure("用户信息更新失败！");
            }
        };
    }
}
