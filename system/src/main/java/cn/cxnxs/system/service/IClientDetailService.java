package cn.cxnxs.system.service;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.system.vo.ClientDetailVO;
import cn.cxnxs.system.vo.PageVO;

import java.util.List;

public interface IClientDetailService {
    PageVO<ClientDetailVO> clientDetailList(PageWrapper<ClientDetailVO> pageWrapper);

    List<ClientDetailVO> allClients(ClientDetailVO clientDetailVO);

    void addApp(ClientDetailVO clientDetailVO);

    ClientDetailVO clientDetail(String clientId);
}
