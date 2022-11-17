package cn.cxnxs.system.controller;

import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.system.service.IClientDetailService;
import cn.cxnxs.system.vo.ClientDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("client")
@RestController
public class ClientDetailController {

    @Autowired
    private IClientDetailService clientDetailService;

    @ResponseResult
    @PostMapping("clientDetails")
    private List<ClientDetailVO> clientDetails(@RequestBody ClientDetailVO clientDetailVO){
        return clientDetailService.clientDetailList(clientDetailVO);
    }
}
