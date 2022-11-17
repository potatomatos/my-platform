package cn.cxnxs.system.service.impl;

import cn.cxnxs.system.mapper.OauthClientDetailsMapper;
import cn.cxnxs.system.service.IClientDetailService;
import cn.cxnxs.system.vo.ClientDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientDetailServiceImpl implements IClientDetailService {

    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public List<ClientDetailVO> clientDetailList(ClientDetailVO clientDetailVO){
        return oauthClientDetailsMapper.selectList(clientDetailVO);
    }
}
