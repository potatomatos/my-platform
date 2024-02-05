package cn.cxnxs.scheduler.core;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * <h2>处理多个event的任务抽象类</h2>
 * <p>比如要合并数据，去重，格式化等等</p>
 */
@Slf4j
@Getter
@Setter
public abstract class MultipleSourcesAgent extends AbstractAgent {

    /**
     * 事件
     */
    private List<Event> events;

    @Override
    public void preStart(RunResult runResult) {
        log.info("----处理多数据----");
    }

}
