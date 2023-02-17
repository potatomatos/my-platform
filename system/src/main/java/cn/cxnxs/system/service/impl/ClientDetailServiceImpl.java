package cn.cxnxs.system.service.impl;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.system.mapper.OauthClientDetailsMapper;
import cn.cxnxs.system.service.IClientDetailService;
import cn.cxnxs.system.vo.ClientDetailVO;
import cn.cxnxs.system.vo.PageVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailServiceImpl implements IClientDetailService {

    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public PageVO<ClientDetailVO> clientDetailList(PageWrapper<ClientDetailVO> pageWrapper){
        ClientDetailVO param = pageWrapper.getParam();
        LambdaQueryWrapper<ClientDetailVO> queryWrapper = new LambdaQueryWrapper<>(ClientDetailVO.class);
        if (StringUtil.isNotEmpty(param.getClientId())) {
            queryWrapper.eq(ClientDetailVO::getClientId,param.getClientId());
        }
        if (StringUtil.isNotEmpty(param.getAppName())) {
            queryWrapper.eq(ClientDetailVO::getAppName,param.getAppName());
        }
        IPage<ClientDetailVO> page = new Page<>();
        page.setCurrent(pageWrapper.getPage());
        page.setSize(pageWrapper.getLimit());
        oauthClientDetailsMapper.selectList(page,queryWrapper);
        PageVO<ClientDetailVO> pageResult = new PageVO<>(page.getTotal());
        pageResult.setCode(Result.ResultEnum.SUCCESS.getCode());
        pageResult.setRows(page.getRecords());
        pageResult.setCount(page.getTotal());
        pageResult.setPageSize((long)pageWrapper.getLimit());
        pageResult.setPages(page.getPages());
        return pageResult;

    }
}
