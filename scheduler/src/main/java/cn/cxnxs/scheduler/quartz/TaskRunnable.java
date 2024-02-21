package cn.cxnxs.scheduler.quartz;

import cn.cxnxs.scheduler.core.IAgent;
import cn.cxnxs.scheduler.core.RunResult;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

/**
 * <p>执行代理线程</p>
 *
 * @author mengjinyuan
 * @date 2021-02-03 11:06
 **/
@Slf4j
@Setter
@Getter
public class TaskRunnable implements Supplier<RunResult> {

    private IAgent agent;

    public TaskRunnable(IAgent agent) {
        this.agent = agent;
    }

    @Override
    public RunResult get() {
        log.info("------开" +
                "始运行任务：{}------", agent.getName());
        return agent.runAgent();
    }
}
