package cn.cxnxs.scheduler.core.agents;

import cn.cxnxs.scheduler.core.Event;
import cn.cxnxs.scheduler.core.MultipleSourcesAgent;
import cn.cxnxs.scheduler.core.RunResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 数据过滤任务
 */
@Component
@Scope("prototype")
@Slf4j
public class TriggerAgent extends MultipleSourcesAgent {
    @Override
    public void start(RunResult runResult) throws Exception {
        List<Event> events = getEvents();
    }
}
