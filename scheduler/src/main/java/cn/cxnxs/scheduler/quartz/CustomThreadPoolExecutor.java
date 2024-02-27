package cn.cxnxs.scheduler.quartz;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PreDestroy;
import java.util.concurrent.*;

@Slf4j
@Getter
@Setter
public class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    private ConcurrentLinkedQueue<Runnable> executingTasks = new ConcurrentLinkedQueue<>();

    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler rejectedExecutionHandler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, rejectedExecutionHandler);
    }

    @Override
    public void execute(Runnable command) {
        executingTasks.add(command);
        super.execute(command);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        executingTasks.remove(r);
    }

    @PreDestroy
    public void cleanUp() {
        this.shutdown();
    }
}