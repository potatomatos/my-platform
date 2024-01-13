package cn.cxnxs.system.service;

import cn.cxnxs.common.api.auth.Oauth2Service;
import cn.cxnxs.common.api.system.domain.UserApiEntity;
import cn.cxnxs.common.core.entity.TreeVo;
import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.PageResult;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.exception.CommonException;
import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.minio.config.MinioProperties;
import cn.cxnxs.minio.config.MinioTemplate;
import cn.cxnxs.system.entity.SysMenu;
import cn.cxnxs.system.entity.SysUserRole;
import cn.cxnxs.system.entity.SysUsers;
import cn.cxnxs.system.mapper.SysMenuMapper;
import cn.cxnxs.system.mapper.SysUserRoleMapper;
import cn.cxnxs.system.mapper.SysUsersMapper;
import cn.cxnxs.system.vo.MenuVO;
import cn.cxnxs.system.vo.RoleVO;
import cn.cxnxs.system.vo.UserVO;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-10-27 23:59
 **/
@Service
public class UserServiceImpl {

    @Resource
    private SysUsersMapper sysUsersMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private MenuServiceImpl menuService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MinioTemplate minioTemplate;

    @Autowired
    private Oauth2Service oauth2Service;

    @Autowired
    private MinioProperties minioProperties;

    /**
     * 分页查询用户信息
     *
     * @param wrapper
     * @return
     */

    public PageResult<UserVO> selectUsersForPage(PageWrapper<UserVO> wrapper) {
        UserVO param = wrapper.getParam();
        LambdaQueryWrapper<SysUsers> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtil.isNotEmpty(param.getUsername())) {
            queryWrapper.like(SysUsers::getUsername, param.getUsername());
        }
        if (StringUtil.isNotEmpty(param.getRealName())) {
            queryWrapper.like(SysUsers::getRealName, param.getRealName());
        }
        if (!Objects.isNull(param.getState())) {
            queryWrapper.eq(SysUsers::getState, param.getState());
        } else {
            //默认查已删除的
            queryWrapper.ne(SysUsers::getState, UserVO.USER_STATE.DELETED.getCode());
        }
        if (!Objects.isNull(param.getId())) {
            queryWrapper.eq(SysUsers::getId, param.getId());
        }
        queryWrapper.orderByDesc(SysUsers::getId);
        Page<Object> page = PageHelper.startPage(wrapper.getPage(), wrapper.getLimit());
        List<SysUsers> sysUsers = sysUsersMapper.selectList(queryWrapper);
        PageResult<UserVO> pageResult = new PageResult<>(wrapper.getPage(), wrapper.getLimit());
        pageResult.setCode(Result.ResultEnum.SUCCESS.getCode());
        pageResult.setRows(ObjectUtil.copyListProperties(sysUsers, UserVO.class));
        pageResult.setCount(page.getTotal());
        pageResult.setPages(page.getPages());
        return pageResult;
    }

    /**
     * 更新用户信息
     *
     * @return 变动行数
     */
    @Transactional

    public Integer updateUser(UserVO userVO) {
        if (userVO.getId() == null) {
            throw new CommonException("id不能为空");
        }
        SysUsers sysUsers = new SysUsers();
        ObjectUtil.transValues(userVO, sysUsers);
        sysUsers.setUpdatedAt(LocalDateTime.now());
        List<Integer> roleIds = userVO.getRoleIds();
        if (roleIds != null && !roleIds.isEmpty()) {
            // 先删后插
            sysUserRoleMapper.delete(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, userVO.getId()));
            SysUserRole sysUserRole = new SysUserRole();
            for (Integer roleId : roleIds) {
                sysUserRole.setUserId(userVO.getId());
                sysUserRole.setRoleId(roleId);
                sysUserRole.setCreatedAt(System.currentTimeMillis());
                sysUserRoleMapper.insert(sysUserRole);
            }
        }
        return sysUsersMapper.updateById(sysUsers);
    }

    /**
     * 添加用户
     *
     * @param userVO
     * @return
     */
    @Transactional

    public Integer addUser(UserVO userVO) {
        SysUsers sysUsers = new SysUsers();
        ObjectUtil.transValues(userVO, sysUsers);
        sysUsers.setEncryptedPassword(passwordEncoder.encode(userVO.getPassword()));
        sysUsers.setCreatedAt(LocalDateTime.now());
        sysUsersMapper.insert(sysUsers);
        List<Integer> roleIds = userVO.getRoleIds();
        if (roleIds != null && !roleIds.isEmpty()) {
            SysUserRole sysUserRole = new SysUserRole();
            for (Integer roleId : roleIds) {
                sysUserRole.setUserId(sysUsers.getId());
                sysUserRole.setRoleId(roleId);
                sysUserRole.setCreatedAt(System.currentTimeMillis());
                sysUserRoleMapper.insert(sysUserRole);
            }
        }

        return sysUsers.getId();
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */

    public Integer delUser(Integer userId) {
        return sysUsersMapper.deleteById(userId);
    }

    /**
     * 逻辑删除用户
     *
     * @param userId
     * @return
     */

    public Integer logicDelUser(Integer userId) {
        SysUsers sysUsers = new SysUsers();
        sysUsers.setId(userId);
        sysUsers.setState(UserVO.USER_STATE.DELETED.getCode());
        return sysUsersMapper.updateById(sysUsers);
    }


    public UserVO getUser(Integer userId) {
        SysUsers sysUsers = sysUsersMapper.selectById(userId);
        UserVO userVO = new UserVO();
        ObjectUtil.transValues(sysUsers, userVO);
        RoleVO roleVO = new RoleVO();
        roleVO.setUserId(userId);
        List<RoleVO> roles = this.selectUserRoles(roleVO);
        userVO.setUserRoles(roles);
        userVO.setRoleIds(roles.stream().map(RoleVO::getId).collect(Collectors.toList()));
        return userVO;
    }

    /**
     * 查询用户绑定角色
     *
     * @param roleVO
     * @return
     */

    public List<RoleVO> selectUserRoles(RoleVO roleVO) {
        return sysUsersMapper.getUserRolesBound(roleVO);
    }


    public UserApiEntity getUserByName(String username) {
        SysUsers sysUsers = sysUsersMapper.selectOne(new LambdaQueryWrapper<SysUsers>()
                .eq(SysUsers::getUsername, username).ne(SysUsers::getState, UserVO.USER_STATE.DELETED.getCode())
        );
        if (sysUsers == null) {
            return null;
        }
        UserApiEntity userApiEntity = new UserApiEntity();
        BeanUtils.copyProperties(sysUsers, userApiEntity);
        List<String> userClients = sysUsersMapper.getUserClients(sysUsers.getId());
        List<String> userRoles = sysUsersMapper.getUserRoles(sysUsers.getId());
        List<Map<String, String>> userPermissions = sysUsersMapper.getUserPermissions(sysUsers.getId());
        final List<SysMenu> userMenus = sysMenuMapper.getUserMenus(sysUsers.getId());
        userApiEntity.setUserClients(userClients);
        userApiEntity.setUserRoles(userRoles);
        List<TreeVo> userMenuTree = menuService.toTree(userMenus);
        List<MenuVO> menuVOS = this.buildPath(userMenuTree, null, null);
        userApiEntity.setUserMenus(userMenuTree);
        userApiEntity.setUserMenuPaths(menuVOS.stream().map(MenuVO::getPath).collect(Collectors.toList()));
        userApiEntity.setPermissions(userPermissions);
        return userApiEntity;
    }

    /**
     * 重置密码
     *
     * @param userId
     * @return
     */

    public Boolean resetPassword(Integer userId) {
        return this.updatePassword(userId, "123456");
    }

    /**
     * 修改密码
     *
     * @param userId
     * @return
     */

    public Boolean updatePassword(Integer userId, String password) {
        SysUsers sysUsers = new SysUsers();
        sysUsers.setId(userId);
        sysUsers.setEncryptedPassword(passwordEncoder.encode(password));
        sysUsersMapper.updateById(sysUsers);
        return true;
    }

    /**
     * 头像上传
     *
     * @param file
     * @return
     */

    public String uploadAvatar(MultipartFile file) {
        Result<JSONObject> result = oauth2Service.currentUser();
        String filename = minioTemplate.upload(file, minioProperties.getBucketName(), "avatar/" + result.getData().getString("id"));
        return minioProperties.getUrl() + "/" + filename;
    }

    private List<MenuVO> buildPath(List<TreeVo> menuTree, List<MenuVO> list, MenuVO parent) {
        if (list == null) {
            list = new ArrayList<>();
        }
        for (TreeVo treeVo : menuTree) {
            MenuVO menuVO = (MenuVO) treeVo;
            if (parent != null) {
                if (menuVO.getPath().indexOf("/") != 0) {
                    menuVO.setPath(parent.getPath() + "/" + menuVO.getPath());
                } else {
                    menuVO.setPath(parent.getPath() + menuVO.getPath());
                }
            }
            list.add(menuVO);
            if (menuVO.getChildren() != null && !menuVO.getChildren().isEmpty()) {
                buildPath(menuVO.getChildren(), list, menuVO);
            }
        }
        return list;
    }
}
