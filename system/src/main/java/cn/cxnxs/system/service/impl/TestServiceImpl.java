package cn.cxnxs.system.service.impl;

import cn.cxnxs.system.entity.Test;
import cn.cxnxs.system.mapper.TestMapper;
import cn.cxnxs.system.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件夹 服务实现类
 * </p>
 *
 * @author mengjinyuan
 * @since 2022-02-17
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

    @Override
    public Test getUserInfo() {
        return getById(1);
    }
}
