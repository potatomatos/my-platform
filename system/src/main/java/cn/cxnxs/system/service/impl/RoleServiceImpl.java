package cn.cxnxs.system.service.impl;

import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.system.entity.SysRole;
import cn.cxnxs.system.mapper.SysRoleMapper;
import cn.cxnxs.system.service.IRoleService;
import cn.cxnxs.system.vo.RoleVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 所有角色
     * @return
     */
    @Override
    public List<RoleVO> listRole(RoleVO roleVO) {
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtil.isNotEmpty(roleVO.getRoleCode())){
            queryWrapper.like(SysRole::getRoleCode,roleVO.getRoleCode());
        }
        if (StringUtil.isNotEmpty(roleVO.getRoleName())){
            queryWrapper.like(SysRole::getRoleName,roleVO.getRoleName());
        }
        List<SysRole> sysRoles = sysRoleMapper.selectList(queryWrapper);
        return ObjectUtil.copyListProperties(sysRoles, RoleVO.class);
    }
}
