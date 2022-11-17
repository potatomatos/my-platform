package cn.cxnxs.system.service.impl;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.system.entity.SysRole;
import cn.cxnxs.system.entity.SysRoleMenu;
import cn.cxnxs.system.mapper.SysRoleMapper;
import cn.cxnxs.system.mapper.SysRoleMenuMapper;
import cn.cxnxs.system.service.IRoleService;
import cn.cxnxs.system.vo.PageVO;
import cn.cxnxs.system.vo.RoleVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author potatomato
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 所有角色
     * @return
     */
    @Override
    public List<RoleVO> listRole(RoleVO roleVO) {
        LambdaQueryWrapper<SysRole> queryWrapper = this.buildCondition(roleVO);
        List<SysRole> sysRoles = sysRoleMapper.selectList(queryWrapper);
        return ObjectUtil.copyListProperties(sysRoles, RoleVO.class);
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public PageVO<RoleVO> pageRole(PageWrapper<RoleVO> pageWrapper) {
        RoleVO param = pageWrapper.getParam();
        LambdaQueryWrapper<SysRole> queryWrapper = this.buildCondition(param);
        IPage<SysRole> page = new Page<>();
        page.setCurrent(pageWrapper.getPage());
        page.setSize(pageWrapper.getLimit());
        sysRoleMapper.selectPage(page,queryWrapper);

        PageVO<RoleVO> pageResult = new PageVO<>(page.getTotal());
        pageResult.setCode(Result.ResultEnum.SUCCESS.getCode());
        pageResult.setRows(ObjectUtil.copyListProperties(page.getRecords(), RoleVO.class));
        pageResult.setCount(page.getTotal());
        pageResult.setPageSize((long)pageWrapper.getLimit());
        pageResult.setPages(page.getPages());
        return pageResult;
    }

    @Override
    public RoleVO getRoleById(Integer id) {
        RoleVO roleVO = new RoleVO();
        SysRole sysRole = sysRoleMapper.selectById(id);
        if (sysRole!=null) {
            ObjectUtil.transValues(sysRole,roleVO);
        }
        // 获得角色绑定的菜单
        List<SysRoleMenu> sysRoleMenus = sysRoleMenuMapper.selectList(new LambdaQueryWrapper<SysRoleMenu>()
                .eq(SysRoleMenu::getRoleId, id));
        roleVO.setMenuIds(sysRoleMenus.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList()));
        return roleVO;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Integer update(RoleVO roleVO) {
        SysRole sysRole = new SysRole();
        ObjectUtil.transValues(roleVO,sysRole);
        int count = sysRoleMapper.updateById(sysRole);
        // 角色菜单关系，先删后插
        sysRoleMenuMapper.delete(new LambdaQueryWrapper<SysRoleMenu>().eq(SysRoleMenu::getRoleId,sysRole.getId()));
        for (Integer menuId : roleVO.getMenuIds()) {
            this.insertRoleMenu(sysRole.getId(),menuId);
        }
        return count;
    }

    @Override
    public Integer add(RoleVO roleVO) {
        SysRole sysRole = new SysRole();
        ObjectUtil.transValues(roleVO,sysRole);
        sysRole.setCreatedAt(System.currentTimeMillis());
        int count = sysRoleMapper.insert(sysRole);
        for (Integer menuId : roleVO.getMenuIds()) {
            this.insertRoleMenu(sysRole.getId(),menuId);
        }
        return count;
    }

    private void insertRoleMenu(Integer roleId,Integer menuId){
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        sysRoleMenu.setRoleId(roleId);
        sysRoleMenu.setMenuId(menuId);
        sysRoleMenu.setCreatedAt(System.currentTimeMillis());
        sysRoleMenu.insert();
    }

    private LambdaQueryWrapper<SysRole> buildCondition(RoleVO param){
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtil.isNotEmpty(param.getRoleCode())){
            queryWrapper.like(SysRole::getRoleCode,param.getRoleCode());
        }
        if (StringUtil.isNotEmpty(param.getRoleName())){
            queryWrapper.like(SysRole::getRoleName,param.getRoleName());
        }
        return queryWrapper;
    }
}
