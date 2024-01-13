package cn.cxnxs.system.service;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.system.entity.OauthClientDetails;
import cn.cxnxs.system.entity.SysApp;
import cn.cxnxs.system.mapper.OauthClientDetailsMapper;
import cn.cxnxs.system.mapper.SysAppMapper;
import cn.cxnxs.system.vo.ClientDetailVO;
import cn.cxnxs.system.vo.PageVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author potatomato
 */
@Service
public class ClientDetailServiceImpl {

    @Resource
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Resource
    private SysAppMapper sysAppMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public PageVO<ClientDetailVO> clientDetailList(PageWrapper<ClientDetailVO> pageWrapper) {
        ClientDetailVO param = pageWrapper.getParam();
        PageHelper.startPage(pageWrapper.getPage(), pageWrapper.getLimit());
        List<ClientDetailVO> detailVOList = oauthClientDetailsMapper.selectList(param);
        PageInfo<ClientDetailVO> page = new PageInfo<>(detailVOList);
        PageVO<ClientDetailVO> pageResult = new PageVO<>(page.getTotal());
        pageResult.setCode(Result.ResultEnum.SUCCESS.getCode());
        pageResult.setRows(detailVOList);
        pageResult.setCount(page.getTotal());
        pageResult.setPageSize(pageWrapper.getLimit());
        pageResult.setPages(page.getPages());
        return pageResult;

    }

    public List<ClientDetailVO> allClients(ClientDetailVO clientDetailVO) {
        return oauthClientDetailsMapper.selectList(clientDetailVO);
    }

    @Transactional(rollbackFor = Exception.class)
    public void addApp(ClientDetailVO clientDetailVO) {
        OauthClientDetails oauthClientDetails = new OauthClientDetails();
        BeanUtils.copyProperties(clientDetailVO, oauthClientDetails);
        // 加密
        oauthClientDetails.setClientSecret(passwordEncoder.encode(oauthClientDetails.getClientSecret()));
        oauthClientDetails.setScope("all");
        SysApp sysApp = new SysApp();
        BeanUtils.copyProperties(clientDetailVO, sysApp);
        sysApp.setCreatedAt(System.currentTimeMillis());
        oauthClientDetails.insert();
        sysApp.insert();
    }

    public ClientDetailVO clientDetail(String clientId) {
        ClientDetailVO clientDetailVO = new ClientDetailVO();
        OauthClientDetails oauthClientDetails = oauthClientDetailsMapper.selectById(clientId);
        if (oauthClientDetails != null) {
            BeanUtils.copyProperties(oauthClientDetails, clientDetailVO);
            SysApp sysApp = sysAppMapper.selectOne(new LambdaQueryWrapper<SysApp>().eq(SysApp::getClientId, clientId));
            BeanUtils.copyProperties(sysApp, clientDetailVO);
        }
        return clientDetailVO;
    }

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
