package cn.cxnxs.system.service;

import cn.cxnxs.system.vo.ClientDetailVO;

import java.util.List;

public interface IClientDetailService {
    List<ClientDetailVO> clientDetailList(ClientDetailVO clientDetailVO);
}
