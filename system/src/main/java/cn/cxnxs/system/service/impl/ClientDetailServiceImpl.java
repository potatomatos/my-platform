package cn.cxnxs.system.service.impl;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.system.entity.OauthClientDetails;
import cn.cxnxs.system.entity.SysApp;
import cn.cxnxs.system.mapper.OauthClientDetailsMapper;
import cn.cxnxs.system.mapper.SysAppMapper;
import cn.cxnxs.system.service.IClientDetailService;
import cn.cxnxs.system.vo.ClientDetailVO;
import cn.cxnxs.system.vo.PageVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ClientDetailServiceImpl implements IClientDetailService {

    @Resource
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Resource
    private SysAppMapper sysAppMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public PageVO<ClientDetailVO> clientDetailList(PageWrapper<ClientDetailVO> pageWrapper) {
        ClientDetailVO param = pageWrapper.getParam();
        LambdaQueryWrapper<ClientDetailVO> queryWrapper = this.buildCondition(param);
        IPage<ClientDetailVO> page = new Page<>();
        page.setCurrent(pageWrapper.getPage());
        page.setSize(pageWrapper.getLimit());
        List<ClientDetailVO> clientDetailVOS = oauthClientDetailsMapper.selectList(page, queryWrapper);
        PageVO<ClientDetailVO> pageResult = new PageVO<>(page.getTotal());
        pageResult.setCode(Result.ResultEnum.SUCCESS.getCode());
        pageResult.setRows(clientDetailVOS);
        pageResult.setCount(page.getTotal());
        pageResult.setPageSize((long) pageWrapper.getLimit());
        pageResult.setPages(page.getPages());
        return pageResult;

    }

    @Override
    public List<ClientDetailVO> allClients(ClientDetailVO clientDetailVO) {
        LambdaQueryWrapper<ClientDetailVO> queryWrapper = this.buildCondition(clientDetailVO);
        return oauthClientDetailsMapper.selectList(queryWrapper);
    }

    LambdaQueryWrapper<ClientDetailVO> buildCondition(ClientDetailVO clientDetailVO) {
        LambdaQueryWrapper<ClientDetailVO> queryWrapper = new LambdaQueryWrapper<>(ClientDetailVO.class);
        if (StringUtil.isNotEmpty(clientDetailVO.getClientId())) {
            queryWrapper.eq(ClientDetailVO::getClientId, clientDetailVO.getClientId());
        }
        if (StringUtil.isNotEmpty(clientDetailVO.getAppName())) {
            queryWrapper.eq(ClientDetailVO::getAppName, clientDetailVO.getAppName());
        }
        return queryWrapper;
    }

    @Transactional
    @Override
    public void addApp(ClientDetailVO clientDetailVO) {
        OauthClientDetails oauthClientDetails = new OauthClientDetails();
        BeanUtils.copyProperties(clientDetailVO, oauthClientDetails);
        // 加密
        oauthClientDetails.setClientSecret(passwordEncoder.encode(oauthClientDetails.getClientSecret()));
        oauthClientDetails.setScope("all");
        SysApp sysApp = new SysApp();
        BeanUtils.copyProperties(clientDetailVO, sysApp);
        sysApp.setCreatedAt(new Date().getTime());
        oauthClientDetails.insert();
        sysApp.insert();
    }

    @Override
    public ClientDetailVO clientDetail(String clientId) {
        ClientDetailVO clientDetailVO = new ClientDetailVO();
        OauthClientDetails oauthClientDetails = oauthClientDetailsMapper.selectById(clientId);
        if (oauthClientDetails != null) {
            BeanUtils.copyProperties(oauthClientDetails, clientDetailVO);
            SysApp sysApp = sysAppMapper.selectOne(new LambdaQueryWrapper<SysApp>().eq(SysApp::getClientId, clientId));
            BeanUtils.copyProperties(sysApp, clientDetailVO);
            clientDetailVO.setClientSecret(null);
        }
        return clientDetailVO;
    }

    @Override
    public void update(ClientDetailVO clientDetailVO) {
        OauthClientDetails oauthClientDetails = new OauthClientDetails();
        BeanUtils.copyProperties(clientDetailVO, oauthClientDetails);
        SysApp sysApp = new SysApp();
        BeanUtils.copyProperties(clientDetailVO, sysApp);
        sysApp.setUpdatedAt(new Date().getTime());
        oauthClientDetails.updateById();
        sysApp.updateById();
    }
}
