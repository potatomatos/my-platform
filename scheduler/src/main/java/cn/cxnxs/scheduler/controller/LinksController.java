package cn.cxnxs.scheduler.controller;

import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.scheduler.entity.ScheduleLinks;
import cn.cxnxs.scheduler.vo.LinksVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * agent关联 前端控制器
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
@Controller
@RequestMapping("/links")
public class LinksController {

    @ResponseResult
    @RequestMapping
    public List<ScheduleLinks> getLinks(LinksVO linksVO) {
        ScheduleLinks links = new ScheduleLinks();
        ObjectUtil.transValues(linksVO, links);
        return links.selectAll();
    }
}

