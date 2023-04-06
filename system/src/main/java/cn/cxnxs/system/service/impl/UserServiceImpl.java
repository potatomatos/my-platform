package cn.cxnxs.system.service.impl;

import cn.cxnxs.common.api.auth.Oauth2Service;
import cn.cxnxs.common.api.system.domain.UserApiEntity;
import cn.cxnxs.common.core.entity.TreeVo;
import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.exception.CommonException;
import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.system.config.MinioProperties;
import cn.cxnxs.system.config.MinioTemplate;
import cn.cxnxs.system.entity.SysMenu;
import cn.cxnxs.system.entity.SysUserRole;
import cn.cxnxs.system.entity.SysUsers;
import cn.cxnxs.system.mapper.SysMenuMapper;
import cn.cxnxs.system.mapper.SysUserRoleMapper;
import cn.cxnxs.system.mapper.SysUsersMapper;
import cn.cxnxs.system.service.IUserService;
import cn.cxnxs.system.vo.MenuVO;
import cn.cxnxs.system.vo.PageVO;
import cn.cxnxs.system.vo.RoleVO;
import cn.cxnxs.system.vo.UserVO;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public class UserServiceImpl implements IUserService {

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
    @Override
    public PageVO<UserVO> selectUsersForPage(PageWrapper<UserVO> wrapper) {
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
        IPage<SysUsers> page = new Page<>();
        page.setCurrent(wrapper.getPage());
        page.setSize(wrapper.getLimit());
        sysUsersMapper.selectPage(page, queryWrapper);
        PageVO<UserVO> pageResult = new PageVO<>(page.getTotal());
        pageResult.setCode(Result.ResultEnum.SUCCESS.getCode());
        pageResult.setRows(ObjectUtil.copyListProperties(page.getRecords(), UserVO.class));
        pageResult.setCount(page.getTotal());
        pageResult.setPageSize((long) wrapper.getLimit());
        pageResult.setPages(page.getPages());
        return pageResult;
    }

    /**
     * 更新用户信息
     *
     * @return 变动行数
     */
    @Transactional
    @Override
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
    @Override
    public Integer addUser(UserVO userVO) {
        SysUsers sysUsers = new SysUsers();
        ObjectUtil.transValues(userVO, sysUsers);
        sysUsers.setEncryptedPassword(passwordEncoder.encode(userVO.getPassword()));
        sysUsers.setCreatedAt(LocalDateTime.now());
        return sysUsersMapper.insert(sysUsers);
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public Integer delUser(Integer userId) {
        return sysUsersMapper.deleteById(userId);
    }

    /**
     * 逻辑删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public Integer logicDelUser(Integer userId) {
        SysUsers sysUsers = new SysUsers();
        sysUsers.setId(userId);
        sysUsers.setState(UserVO.USER_STATE.DELETED.getCode());
        return sysUsersMapper.updateById(sysUsers);
    }

    @Override
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
    @Override
    public List<RoleVO> selectUserRoles(RoleVO roleVO) {
        return sysUsersMapper.getUserRolesBound(roleVO);
    }

    @Override
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
     * @param userId
     * @return
     */
    @Override
    public Boolean resetPassword(Integer userId) {
        SysUsers sysUsers = new SysUsers();
        sysUsers.setId(userId);
        sysUsers.setEncryptedPassword(passwordEncoder.encode("123456"));
        sysUsersMapper.updateById(sysUsers);
        return true;
    }

    /**
     * 头像上传
     * @param file
     * @return
     */
    @Override
    public String uploadAvatar(MultipartFile file){
        Result<JSONObject> result = oauth2Service.currentUser();
        String filename = minioTemplate.upload(file, minioProperties.getBucketName(), "avatar/" + result.getData().getString("id"));
        return minioProperties.getUrl()+ "/" +filename;
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
            if (menuVO.getChildren()!=null&&!menuVO.getChildren().isEmpty()) {
                buildPath(menuVO.getChildren(), list, menuVO);
            }
        }
        return list;
    }
}
