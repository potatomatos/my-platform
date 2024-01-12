package cn.cxnxs.scheduler.quartz;

import cn.cxnxs.scheduler.core.Event;
import cn.cxnxs.scheduler.core.IAgent;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * <p>执行代理线程</p>
 *
 * @author mengjinyuan
 * @date 2021-02-03 11:06
 **/
@Setter
@Getter
public class TaskRunnable implements Callable<List<Map<String, String>>> {

    private IAgent agent;

    private Event event;

    private static final Logger logger = LoggerFactory.getLogger(TaskRunnable.class);

    @Override
    public List<Map<String, String>> call() throws Exception {
        logger.info("------开始运行代理------");
        return agent.collect(getEvent());
    }
}
