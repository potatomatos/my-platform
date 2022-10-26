package cn.cxnxs.system.controller;

import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.system.entity.Test;
import cn.cxnxs.system.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-10-26 22:59
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private ITestService testService;

    @ResponseResult
    @RequestMapping("getUserInfo")
    public Test getUserInfo(){
        return testService.getUserInfo();
    }
}
