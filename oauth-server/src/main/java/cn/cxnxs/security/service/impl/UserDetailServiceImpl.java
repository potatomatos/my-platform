package cn.cxnxs.security.service.impl;

import cn.cxnxs.common.api.system.SystemService;
import cn.cxnxs.common.api.system.domain.UserApiEntity;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.security.entity.CustomGrantedAuthority;
import cn.cxnxs.security.entity.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>用户信息配置</p>
 *
 * @author mengjinyuan
 * @date 2022-04-09 23:14
 **/
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SystemService systemService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        //从数据库获取权限
        Result<UserApiEntity> result = systemService.getUserByName(username);
        UserApiEntity userApiEntity;
        if (result.ok()){
            userApiEntity = result.getData();
        }else {
            throw new BadCredentialsException("用户信息获取失败");
        }

        if (userApiEntity ==null){
            //表示用户不存在
            throw  new UsernameNotFoundException("用户名或密码错误");
        }
        //取出正确密码（密文）
        String password = userApiEntity.getEncryptedPassword();
        boolean enabled=true;
        boolean accountNonExpired=true;
        boolean credentialsNonExpired=true;
        boolean accountNonLocked=true;

        if (JwtUser.USER_STATE.DISABLED.getCode().equals(userApiEntity.getState())){
            enabled=false;
        }
        if (JwtUser.USER_STATE.ACCOUNT_EXPIRED.getCode().equals(userApiEntity.getState())){
            accountNonExpired=false;
        }
        if (JwtUser.USER_STATE.CREDENTIALS_EXPIRED.getCode().equals(userApiEntity.getState())){
            credentialsNonExpired=false;
        }
        if (JwtUser.USER_STATE.ACCOUNT_LOCKED.getCode().equals(userApiEntity.getState())){
            accountNonLocked=false;
        }
        //获取用户客户端信息
        List<String> userClients = userApiEntity.getUserClients();
        //获取用户的所有角色
        List<String> userRoles = userApiEntity.getUserRoles();
        //获取用户的权限信息
        List<Map<String, String>> permissions = userApiEntity.getPermissions();
        //根据角色分组权限
        Map<String,List<Map<String, String>>> rolePermissions=permissions.stream().collect(Collectors.groupingBy(e->e.get("role_code")));

//        JwtUser userDetails = new JwtUser(username,
//                password,
//                enabled,
//                accountNonExpired,
//                credentialsNonExpired,
//                accountNonLocked,
//                AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", userRoles)));
        JwtUser userDetails = new JwtUser();
        userDetails.setEnabled(enabled);
        userDetails.setAccountNonExpired(accountNonExpired);
        userDetails.setCredentialsNonExpired(credentialsNonExpired);
        userDetails.setAccountNonLocked(accountNonLocked);
        userDetails.setAuthorities(userRoles.stream().map(CustomGrantedAuthority::new).collect(Collectors.toList()));
        userDetails.setPassword(password);
        userDetails.setId(userApiEntity.getId());
        userDetails.setUsername(userApiEntity.getUsername());
        userDetails.setRealName(userApiEntity.getRealName());
        userDetails.setAvatar(userApiEntity.getAvatar());
        userDetails.setPhoneNumber(userApiEntity.getPhoneNumber());
        userDetails.setEmail(userApiEntity.getEmail());
        userDetails.setLoginCount(userApiEntity.getLoginCount());
        userDetails.setCurrentLoginIp(userApiEntity.getCurrentLoginIp());
        userDetails.setPermissions(permissions);
        userDetails.setUserClients(userClients);
        userDetails.setUserRoles(userRoles);
        userDetails.setUserMenus(userApiEntity.getUserMenus());
        userDetails.setUserMenuPaths(userApiEntity.getUserMenuPaths());
        userDetails.setRolePermissions(rolePermissions);
        return userDetails;
    }
}
