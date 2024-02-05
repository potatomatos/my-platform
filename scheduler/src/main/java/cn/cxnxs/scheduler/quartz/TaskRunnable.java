package cn.cxnxs.scheduler.quartz;

import cn.cxnxs.scheduler.core.IAgent;
import cn.cxnxs.scheduler.core.RunResult;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * <p>执行代理线程</p>
 *
 * @author mengjinyuan
 * @date 2021-02-03 11:06
 **/
@Slf4j
@Setter
@Getter
public class TaskRunnable implements Callable<RunResult> {

    private IAgent agent;

    @Override
    public RunResult call() {
        log.info("------开始运行任务：{}------", agent.getName());
        return agent.runAgent();
    }
}
