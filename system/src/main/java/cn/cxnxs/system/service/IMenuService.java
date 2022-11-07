package cn.cxnxs.system.service;

import cn.cxnxs.common.core.entity.TreeVo;

import java.util.List;

/**
 * 菜单服务
 */
public interface IMenuService {

    /**
     * 获取当前用户权限菜单树
     * @return 用户分配的菜单列表树
     */
    List<TreeVo> getUserMenusTree();
}
