package cn.cxnxs.system.service;

import cn.cxnxs.system.vo.RoleVO;

import java.util.List;

public interface IRoleService {
    /**
     * 所有角色
     * @return
     */
    List<RoleVO> listRole(RoleVO roleVO);
}
