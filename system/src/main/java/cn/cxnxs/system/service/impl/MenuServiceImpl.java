package cn.cxnxs.system.service.impl;

import cn.cxnxs.common.api.Oauth2Service;
import cn.cxnxs.common.core.entity.TreeVo;
import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.PageResult;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.exception.CommonException;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.common.core.utils.TreeUtil;
import cn.cxnxs.system.entity.SysMenu;
import cn.cxnxs.system.mapper.SysMenuMapper;
import cn.cxnxs.system.service.IMenuService;
import cn.cxnxs.system.vo.MenuQueryVO;
import cn.cxnxs.system.vo.MenuVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private Oauth2Service oauth2Service;

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<TreeVo> getUserMenusTree() {
        Result<JSONObject> result = oauth2Service.currentUser();
        if (result.ok()){
            JSONObject userInfo = result.getData();
            final List<SysMenu> userMenus = sysMenuMapper.getUserMenus(userInfo.getInteger("id"));
            return this.toTree(userMenus);
        }else {
            throw new CommonException(result.getMsg());
        }
    }

    /**
     * 获得菜单树
     * @return
     */
    @Override
    public List<TreeVo> getMenusTree() {
        List<SysMenu> sysMenus = sysMenuMapper.selectList(new LambdaQueryWrapper<SysMenu>().orderByAsc(SysMenu::getSortNo));
        return this.toTree(sysMenus);
    }


    /**
     * 对象转换
     * @param menus
     * @return
     */
    private List<TreeVo> toTree(List<SysMenu> menus){
        List<TreeVo> treeVos = new ArrayList<>();
        menus.forEach(sysMenu -> {
            MenuVO menuVO = new MenuVO();
            menuVO.setId(sysMenu.getId());
            menuVO.setParentId(sysMenu.getParentId());
            menuVO.setPath(sysMenu.getUrl());
            menuVO.setTitle(sysMenu.getMenuName());
            menuVO.setIcon(sysMenu.getIcon());
            menuVO.setIconSvg(sysMenu.getIconSvg());
            menuVO.setDescription(sysMenu.getDescription());
            menuVO.setState(sysMenu.getState());

            TreeVo treeVo = new TreeVo();
            treeVo.setId(sysMenu.getId());
            treeVo.setPid(sysMenu.getParentId());
            treeVo.setTitle(sysMenu.getMenuName());
            treeVo.setHref(sysMenu.getUrl());
            treeVo.setIcon(sysMenu.getIcon());
            treeVo.setExpandData(JSONObject.parseObject(JSON.toJSONString(menuVO)));
            treeVo.setCreateTime(sysMenu.getCreatedAt());
            treeVo.setSort(sysMenu.getSortNo());
            treeVos.add(treeVo);
        });
        return TreeUtil.toTreeVo(treeVos, 0);
    }
    /**
     * 添加菜单
     * @param sysMenu
     * @return
     */
    @Override
    public Integer addMenu(SysMenu sysMenu){
        if (sysMenu!=null){
            return sysMenuMapper.insert(sysMenu);
        }else {
            return 0;
        }
    }

    /**
     * 更新菜单
     * @param sysMenu
     * @return
     */
    @Override
    public Integer updateMenu(SysMenu sysMenu){
        if (sysMenu!=null){
            return sysMenuMapper.updateById(sysMenu);
        }else {
            return 0;
        }
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @Override
    public Integer deleteMenu(Integer id){
        //判断是否有子菜单
        Integer count = sysMenuMapper.selectCount(new LambdaQueryWrapper<SysMenu>().eq(SysMenu::getParentId, id));
        if (count>0){
            throw new CommonException("该菜单存在下级，请完全删除子菜单后再删除本菜单！");
        }
        return sysMenuMapper.deleteById(id);
    }

    /**
     * 分页查询菜单
     * @param pageWrapper
     * @return
     */
    @Override
    public PageResult<SysMenu> list(PageWrapper<MenuQueryVO> pageWrapper){
        MenuQueryVO param = pageWrapper.getParam();
        LambdaQueryWrapper<SysMenu> queryWrapper = new LambdaQueryWrapper<>();
        if (param.getId()!=null){
            queryWrapper.eq(SysMenu::getId,param.getId());
        }
        if (param.getPid()!=null){
            queryWrapper.eq(SysMenu::getParentId,param.getPid());
        }
        if (StringUtil.isNotEmpty(param.getMenuName())){
            queryWrapper.like(SysMenu::getMenuName,param.getMenuName());
        }
        if (StringUtil.isNotEmpty(param.getUrl())){
            queryWrapper.like(SysMenu::getUrl,param.getUrl());
        }
        queryWrapper.orderByAsc(SysMenu::getSortNo);
        Page<SysMenu> page = new Page<>();
        page.setCurrent(pageWrapper.getPage());
        page.setSize(pageWrapper.getLimit());
        Page<SysMenu> sysMenuPage = sysMenuMapper.selectPage(page, queryWrapper);
        PageResult<SysMenu> pageResult = new PageResult<>(page.getTotal());
        pageResult.setRows(sysMenuPage.getRecords());
        pageResult.setPageSize(sysMenuPage.getSize());
        pageResult.setPages(sysMenuPage.getPages());
        pageResult.setCurrent(sysMenuPage.getCurrent());
        return pageResult;
    }
}
