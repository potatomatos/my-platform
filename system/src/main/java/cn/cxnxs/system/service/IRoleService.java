package cn.cxnxs.system.service;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.system.vo.PageVO;
import cn.cxnxs.system.vo.RoleVO;

import java.util.List;

public interface IRoleService {
    /**
     * 所有角色
     * @return
     */
    List<RoleVO> listRole(RoleVO roleVO);

    /**
     * 分页查询
     * @return
     */
    PageVO<RoleVO> pageRole(PageWrapper<RoleVO> pageWrapper);

    RoleVO getRoleById(Integer id);

    Integer update(RoleVO roleVO);

    Integer add(RoleVO roleVO);
}
