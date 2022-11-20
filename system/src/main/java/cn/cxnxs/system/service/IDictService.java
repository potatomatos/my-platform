package cn.cxnxs.system.service;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.system.entity.SysDict;
import cn.cxnxs.system.vo.DictVO;
import cn.cxnxs.system.vo.PageVO;

import java.util.List;

/**
 * 字典相关
 * @author potatomato
 */
public interface IDictService {
    PageVO<DictVO> list(PageWrapper<DictVO> pageWrapper);

    /**
     * 获取字典类型
     * @return
     */
    List<DictVO> getDictTypes();

    Integer addDict(DictVO dictVO);

    SysDict dictInfo(Integer id);

    Integer updateDict(DictVO dictVO);

    Integer delete(Integer id);
}
