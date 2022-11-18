package cn.cxnxs.system.service.impl;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.common.core.utils.TreeUtil;
import cn.cxnxs.system.entity.SysDict;
import cn.cxnxs.system.mapper.SysDictMapper;
import cn.cxnxs.system.service.IDictService;
import cn.cxnxs.system.vo.DictVO;
import cn.cxnxs.system.vo.PageVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>字典相关</p>
 *
 * @author mengjinyuan
 * @date 2022-11-17 23:58
 **/
@Service
public class DictServiceImpl implements IDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public PageVO<DictVO> list(PageWrapper<DictVO> pageWrapper) {
        DictVO param = pageWrapper.getParam();
        LambdaQueryWrapper<SysDict> queryWrapper = buildCondition(param);
        queryWrapper.orderByDesc(SysDict::getId).orderByAsc(SysDict::getCode);
        IPage<SysDict> page = new Page<>();
        page.setCurrent(pageWrapper.getPage());
        page.setSize(pageWrapper.getLimit());
        sysDictMapper.selectPage(page,queryWrapper);
        List<SysDict> records = page.getRecords();
        if (!records.isEmpty()) {
            //获得类型
            List<SysDict> dictTypes = sysDictMapper.selectList(new LambdaQueryWrapper<SysDict>()
                    .eq(SysDict::getDictType,"dict")
                    .in(SysDict::getCode, records.stream().map(SysDict::getDictType).collect(Collectors.toList())));
            records.addAll(dictTypes);
        }
        //整合到一个树上
        List<DictVO> dictVOS = ObjectUtil.copyListProperties(records, DictVO.class);
        //去重
        Set<DictVO> dictSet = new HashSet<>(dictVOS);
        List<DictVO> dictTree = this.toTree(new ArrayList<>(dictSet));

        PageVO<DictVO> pageResult = new PageVO<>(page.getTotal());
        pageResult.setCode(Result.ResultEnum.SUCCESS.getCode());
        pageResult.setRows(dictTree);
        pageResult.setCount(page.getTotal());
        pageResult.setPageSize((long)pageWrapper.getLimit());
        pageResult.setPages(page.getPages());
        return pageResult;
    }

    private List<DictVO> toTree(List<DictVO> dictVOS){
        for (DictVO dictVO : dictVOS) {
            dictVO.setNodeId(dictVO.getCode());
            dictVO.setParentNodeId(dictVO.getDictType());
        }
        return TreeUtil.toTreeVo(dictVOS,"dict");
    }

    private LambdaQueryWrapper<SysDict> buildCondition(DictVO dictVO){
        LambdaQueryWrapper<SysDict> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtil.isNotEmpty(dictVO.getCode())) {
            queryWrapper.eq(SysDict::getCode,dictVO.getCode());
        }
        if (StringUtil.isNotEmpty(dictVO.getLabel())) {
            queryWrapper.like(SysDict::getLabel,dictVO.getLabel());
        }
        if (dictVO.getState()!=null) {
            queryWrapper.eq(SysDict::getState,dictVO.getState());
        }
        if (StringUtil.isNotEmpty(dictVO.getDictType())) {
            queryWrapper.eq(SysDict::getDictType,dictVO.getDictType());
        }
        return queryWrapper;
    }
}
