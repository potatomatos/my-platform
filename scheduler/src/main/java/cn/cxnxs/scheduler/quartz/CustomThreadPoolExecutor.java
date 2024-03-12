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
        try {
            super.execute(command);
        } catch (Exception e) {
            log.error("Task execution error: {}", e.getMessage());
        } finally {
            afterExecute(command, null);
        }
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        executingTasks.remove(r);
        super.afterExecute(r, t);
    }

    @PreDestroy
    public void cleanUp() {
        executingTasks = new ConcurrentLinkedQueue<>();
        this.shutdown();
    }


}
