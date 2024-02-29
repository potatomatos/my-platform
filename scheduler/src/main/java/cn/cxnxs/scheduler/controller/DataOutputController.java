package cn.cxnxs.scheduler.controller;


import cn.cxnxs.scheduler.service.DataOutputService;
import com.alibaba.fastjson.JSONObject;
import com.rometools.rome.io.FeedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("output")
public class DataOutputController {

    @Autowired
    private DataOutputService dataOutputService;

    /**
     * 获取rss
     *
     * @param agentId
     * @return
     * @throws FeedException
     */
    @GetMapping(value = "/{agentId}/xml", produces = {MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public String rssData(@PathVariable("agentId") Integer agentId, @RequestParam("secret") String secret) throws FeedException {
        return dataOutputService.getRssData(agentId, secret);
    }

    /**
     * 获取json数据
     *
     * @param agentId
     * @return
     */
    @GetMapping(value = "/{agentId}/json")
    @ResponseBody
    public JSONObject jsonData(@PathVariable("agentId") Integer agentId, @RequestParam("secret") String secret) {
        return dataOutputService.getOutputData(agentId, secret);
    }
}
