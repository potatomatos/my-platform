package cn.cxnxs.system.service;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.system.vo.DictVO;
import cn.cxnxs.system.vo.PageVO;

/**
 * 字典相关
 * @author potatomato
 */
public interface IDictService {
    PageVO<DictVO> list(PageWrapper<DictVO> pageWrapper);
}
