package cn.cxnxs.system.service;

import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.system.entity.SysPermission;
import cn.cxnxs.system.mapper.SysPermissionMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author mengjinyuan
 **/
@Service
@Slf4j
public class PermissionServiceImpl {


    @Resource
    private SysPermissionMapper sysPermissionMapper;


    /**
     * 判断是否是允许通过的资源
     *
     * @param uri
     * @param clientId
     * @return
     */
    public boolean permit(String uri, String clientId) {
        List<String> permitPermissions = this.permitPermissions(clientId);
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        for (String permitPermission : permitPermissions) {
            if (antPathMatcher.match(permitPermission, uri)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取白名单地址（不拦截的）
     *
     * @return
     */
    public List<String> permitPermissions(String clientId) {
        LambdaQueryWrapper<SysPermission> queryWrapper = new LambdaQueryWrapper<SysPermission>()
                .eq(SysPermission::getPermissionType, 1)
                .eq(SysPermission::getState, 0);
        if (StringUtil.isNotEmpty(clientId)) {
            queryWrapper.eq(SysPermission::getClientId, clientId);
        }
        return sysPermissionMapper.selectList(queryWrapper)
                .stream().map(SysPermission::getApi)
                .collect(Collectors.toList());
    }

}
