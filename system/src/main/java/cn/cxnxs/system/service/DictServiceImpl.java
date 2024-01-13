package cn.cxnxs.system.service;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.PageResult;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.exception.CommonException;
import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.common.core.utils.TreeUtil;
import cn.cxnxs.system.entity.SysDict;
import cn.cxnxs.system.mapper.SysDictMapper;
import cn.cxnxs.system.vo.DictVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>字典相关</p>
 *
 * @author mengjinyuan
 * @date 2022-11-17 23:58
 **/
@Service
public class DictServiceImpl {

    @Autowired
    private SysDictMapper sysDictMapper;

    public PageResult<DictVO> list(PageWrapper<DictVO> pageWrapper) {
        DictVO param = pageWrapper.getParam();
        LambdaQueryWrapper<SysDict> queryWrapper = buildCondition(param);
        queryWrapper.orderByAsc(SysDict::getSort);
        Page<Object> page = PageHelper.startPage(pageWrapper.getPage(), pageWrapper.getLimit());
        List<SysDict> records = sysDictMapper.selectList(queryWrapper);
        if (!records.isEmpty()) {
            //获得类型
            List<SysDict> dictTypes = sysDictMapper.selectList(new LambdaQueryWrapper<SysDict>()
                    .eq(SysDict::getDictType, "dict")
                    .in(SysDict::getCode, records.stream().map(SysDict::getDictType).collect(Collectors.toList())));
            records.addAll(dictTypes);
        }
        //整合到一个树上
        List<DictVO> dictVOS = ObjectUtil.copyListProperties(records, DictVO.class);
        //去重
        Set<DictVO> dictSet = new HashSet<>(dictVOS);
        // 重新排序
        ArrayList<DictVO> list = new ArrayList<>(dictSet);
        list.sort(Comparator.comparing(DictVO::getSort));
        List<DictVO> dictTree = this.toTree(list);
        PageResult<DictVO> result = new PageResult<>(pageWrapper.getPage(), pageWrapper.getLimit());
        result.setCode(Result.ResultEnum.SUCCESS.getCode());
        result.setRows(dictTree);
        result.setCount(page.getTotal());
        result.setPages(page.getPages());
        return result;
    }

    /**
     * 获取字典类型
     *
     * @return
     */
    public List<DictVO> getDictTypes() {
        List<SysDict> dictTypes = sysDictMapper.selectList(new LambdaQueryWrapper<SysDict>()
                .eq(SysDict::getDictType, "dict"));
        return ObjectUtil.copyListProperties(dictTypes, DictVO.class);
    }

    public Integer addDict(DictVO dictVO) {
        SysDict sysDict = new SysDict();
        ObjectUtil.transValues(dictVO, sysDict);
        return sysDictMapper.insert(sysDict);
    }

    public SysDict dictInfo(Integer id) {
        return sysDictMapper.selectById(id);
    }

    public Integer updateDict(DictVO dictVO) {
        SysDict sysDict = new SysDict();
        ObjectUtil.transValues(dictVO, sysDict);
        return sysDictMapper.updateById(sysDict);
    }

    public Integer delete(Integer id) {
        SysDict sysDict = sysDictMapper.selectById(id);
        if (sysDict == null) {
            throw new CommonException("数据不存在");
        }
        //删除本级+下级
        return sysDictMapper.deleteById(id) + sysDictMapper.delete(new LambdaQueryWrapper<SysDict>()
                .eq(SysDict::getDictType, sysDict.getCode()));

    }

    private List<DictVO> toTree(List<DictVO> dictVOS) {
        for (DictVO dictVO : dictVOS) {
            dictVO.setNodeId(dictVO.getCode());
            dictVO.setParentNodeId(dictVO.getDictType());
        }
        return TreeUtil.toTreeVo(dictVOS, "dict");
    }

    private LambdaQueryWrapper<SysDict> buildCondition(DictVO dictVO) {
        LambdaQueryWrapper<SysDict> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtil.isNotEmpty(dictVO.getCode())) {
            queryWrapper.eq(SysDict::getCode, dictVO.getCode());
        }
        if (StringUtil.isNotEmpty(dictVO.getLabel())) {
            queryWrapper.like(SysDict::getLabel, dictVO.getLabel());
        }
        if (dictVO.getState() != null) {
            queryWrapper.eq(SysDict::getState, dictVO.getState());
        }
        if (StringUtil.isNotEmpty(dictVO.getDictType())) {
            queryWrapper.eq(SysDict::getDictType, dictVO.getDictType());
        }
        return queryWrapper;
    }
}
