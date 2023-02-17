package cn.cxnxs.system.service;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.system.vo.ClientDetailVO;
import cn.cxnxs.system.vo.PageVO;

public interface IClientDetailService {
    PageVO<ClientDetailVO> clientDetailList(PageWrapper<ClientDetailVO> pageWrapper);
}
