package cn.cxnxs.system.service;

import cn.cxnxs.common.core.entity.TreeVo;
import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.PageResult;
import cn.cxnxs.system.entity.SysMenu;
import cn.cxnxs.system.vo.MenuQueryVO;

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

    /**
     * 获得菜单树
     * @return
     */
    List<TreeVo> getMenusTree();

    /**
     * 添加菜单
     * @param sysMenu
     * @return
     */
    Integer addMenu(SysMenu sysMenu);

    /**
     * 更新菜单
     * @param sysMenu
     * @return
     */
    Integer updateMenu(SysMenu sysMenu);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    Integer deleteMenu(Integer id);

    /**
     * 分页查询菜单
     * @param pageWrapper
     * @return
     */
    PageResult<SysMenu> list(PageWrapper<MenuQueryVO> pageWrapper);
}
