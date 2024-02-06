package cn.cxnxs.scheduler.core.agents;

import cn.cxnxs.scheduler.core.Event;
import cn.cxnxs.scheduler.core.MultipleSourcesAgent;
import cn.cxnxs.scheduler.core.RunResult;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 数据去重任务
 */
@Component
@Scope("prototype")
@Slf4j
public class DeDuplicationAgent extends MultipleSourcesAgent {
    @Override
    public void start(RunResult runResult) {
        log.info("开始去重数据");
        List<Event> events = getEvents();
        List<JSONObject> list = events.stream().map(Event::getPayload).collect(Collectors.toList());

    }
}
