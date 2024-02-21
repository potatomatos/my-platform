package cn.cxnxs.scheduler.quartz;

import cn.cxnxs.scheduler.core.IAgent;
import cn.cxnxs.scheduler.entity.ScheduleDelayedJobs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义拒绝策略
 */
@Slf4j
@Component
public class RejectedExecutionHandler4DelayedJobs implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            // 获取ListenableFutureTask类中的"task"字段
            Field taskField = Class.forName("java.util.concurrent.CompletableFuture$AsyncSupply").getDeclaredField("fn");
            taskField.setAccessible(true); // 设置私有字段可以访问

            // 从ListenableFutureTask对象中获取"task"字段的值
            Object task = taskField.get(r);

            // 检查task是否是TaskRunnable的实例
            if (task instanceof TaskRunnable) {
                TaskRunnable taskRunnable = (TaskRunnable) task;
                IAgent agent = taskRunnable.getAgent();
                // 序列化存储到数据库
                if (Objects.nonNull(agent)) {
                    String serializeObjectToString = this.serializeObjectToString(agent);
                    if (Objects.nonNull(serializeObjectToString)) {
                        ScheduleDelayedJobs scheduleDelayedJobs = new ScheduleDelayedJobs();
                        scheduleDelayedJobs.setPriority(1);
                        scheduleDelayedJobs.setHandler(serializeObjectToString);
                        scheduleDelayedJobs.setThreadId(Thread.currentThread().getName());
                        scheduleDelayedJobs.setCreatedAt(LocalDateTime.now());
                        scheduleDelayedJobs.insert();
                    }
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }

    public String serializeObjectToString(Object object) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
