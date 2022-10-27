package cn.cxnxs.system.service.impl;

import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.common.web.vo.request.PageWrapper;
import cn.cxnxs.common.web.vo.response.Result;
import cn.cxnxs.system.entity.SysUsers;
import cn.cxnxs.system.mapper.SysUsersMapper;
import cn.cxnxs.system.service.IUserService;
import cn.cxnxs.system.vo.PageVO;
import cn.cxnxs.system.vo.RoleVO;
import cn.cxnxs.system.vo.UserVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
    /**
     * 分页查询用户信息
     *
     * @param wrapper
     * @return
     */
    @Override
    public PageVO<List<UserVO>> selectUsersForPage(PageWrapper<UserVO> wrapper) {
        UserVO param = wrapper.getParam();
        LambdaQueryWrapper<SysUsers> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtil.isNotEmpty(param.getUsername())) {
            queryWrapper.like(SysUsers::getUsername, param.getUsername());
        }
        if (!Objects.isNull(param.getState())) {
            queryWrapper.eq(SysUsers::getState, param.getState());
        }
        if (!Objects.isNull(param.getId())) {
            queryWrapper.eq(SysUsers::getId, param.getId());
        }
        queryWrapper.orderByDesc(SysUsers::getId);
        IPage<SysUsers> page = new Page<>();
        page.setCurrent(wrapper.getPage());
        page.setSize(wrapper.getLimit());
        sysUsersMapper.selectPage(page, queryWrapper);
        PageVO<List<UserVO>> pageResult = new PageVO<>(page.getTotal());
        pageResult.setCode(Result.ResultEnum.SUCCESS.getCode());
        pageResult.setData(ObjectUtil.copyListProperties(page.getRecords(), UserVO.class));
        return pageResult;
    }

    /**
     * 更新用户信息
     *
     * @return 变动行数
     */
    @Override
    public Integer updateUser(UserVO userVO) {
        SysUsers sysUsers = new SysUsers();
        ObjectUtil.transValues(userVO, sysUsers);
        sysUsers.setUpdatedAt(LocalDateTime.now());
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
        sysUsers.setUpdatedAt(LocalDateTime.now());
        return sysUsersMapper.insert(sysUsers);
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public Integer addUser(Integer userId) {
        return sysUsersMapper.deleteById(userId);
    }

    /**
     * 查询用户绑定角色
     * @param wrapper
     * @return
     */
    @Override
    public PageVO<List<RoleVO>> selectUserRoles(PageWrapper<RoleVO> wrapper) {
        RoleVO param = wrapper.getParam();
        PageHelper.startPage(wrapper.getPage(), wrapper.getLimit());
        List<RoleVO> userRolesBound = sysUsersMapper.getUserRolesBound(param);
        PageInfo<RoleVO> pageInfo = new PageInfo<>(userRolesBound);
        PageVO<List<RoleVO>> pageResult = new PageVO<>(pageInfo.getTotal());
        pageResult.setCode(Result.ResultEnum.SUCCESS.getCode());
        pageResult.setData(pageInfo.getList());
        return pageResult;
    }
}
