package cn.cxnxs.system.service.impl;
import cn.cxnxs.common.core.utils.TreeUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import cn.cxnxs.common.api.Oauth2Service;
import cn.cxnxs.common.core.entity.TreeVo;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.exception.CommonException;
import cn.cxnxs.system.entity.SysMenu;
import cn.cxnxs.system.mapper.SysMenuMapper;
import cn.cxnxs.system.service.IMenuService;
import cn.cxnxs.system.vo.MenuVO;
import com.alibaba.fastjson.JSONObject;
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
            List<TreeVo> treeVos = new ArrayList<>();
            userMenus.forEach(sysMenu -> {
                MenuVO menuVO = new MenuVO();
                menuVO.setPath(sysMenu.getUrl());
                menuVO.setTitle(sysMenu.getMenuName());
                menuVO.setIcon(sysMenu.getIcon());
                menuVO.setIconSvg(sysMenu.getIconSvg());

                TreeVo treeVo = new TreeVo();
                treeVo.setId(sysMenu.getId());
                treeVo.setPid(sysMenu.getParentId());
                treeVo.setTitle(sysMenu.getMenuName());
                treeVo.setHref(sysMenu.getUrl());
                treeVo.setIcon(sysMenu.getIcon());
                treeVo.setExpandData(JSONObject.parseObject(JSON.toJSONString(menuVO)));
                treeVo.setCreateTime(sysMenu.getCreatedAt());
                treeVos.add(treeVo);
            });
            return TreeUtil.toTreeVo(treeVos, 0);
        }else {
            throw new CommonException(result.getMsg());
        }
    }
}
