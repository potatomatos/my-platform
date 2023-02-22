package cn.cxnxs.system.controller;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.common.web.annotation.Validation;
import cn.cxnxs.common.web.utils.ValidationUtil;
import cn.cxnxs.system.service.IClientDetailService;
import cn.cxnxs.system.vo.ClientDetailVO;
import cn.cxnxs.system.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("client")
@RestController
public class ClientDetailController {

    @Resource
    private IClientDetailService clientDetailService;

    @ResponseResult
    @PostMapping("clientDetails")
    private PageVO<ClientDetailVO> clientDetails(@RequestBody PageWrapper<ClientDetailVO> pageWrapper){
        return clientDetailService.clientDetailList(pageWrapper);
    }

    @ResponseResult
    @PostMapping("list")
    private List<ClientDetailVO> clientDetails(@RequestBody ClientDetailVO clientDetailVO){
        return clientDetailService.allClients(clientDetailVO);
    }

    @ResponseResult
    @PostMapping("add")
    private Boolean addClient(@RequestBody ClientDetailVO clientDetailVO){
        // 参数校验
        ValidationUtil.validate(clientDetailVO);
        clientDetailService.addApp(clientDetailVO);
        return true;
    }

    @ResponseResult
    @PostMapping("detail")
    private ClientDetailVO addClient(String clientId){
        return clientDetailService.clientDetail(clientId);
    }

}
