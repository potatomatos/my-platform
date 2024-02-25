package cn.cxnxs.scheduler.quartz;

import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.scheduler.core.RunLogs;
import cn.cxnxs.scheduler.entity.ScheduleAgentLogs;
import cn.cxnxs.scheduler.entity.ScheduleEvents;
import cn.cxnxs.scheduler.enums.RunState;
import cn.cxnxs.scheduler.service.EventsServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Component
public class JobSupport {

    @Autowired
    private EventsServiceImpl eventsService;


    /**
     * 保存日志信息
     *
     * @param runLogs
     * @param success
     */
    public ScheduleAgentLogs saveLogs(Integer agentId, ScheduleAgentLogs scheduleAgentLogs, RunLogs runLogs, Boolean success) {

        if (scheduleAgentLogs == null) {
            //新增
            scheduleAgentLogs = new ScheduleAgentLogs();
            scheduleAgentLogs.setAgentId(agentId);
            scheduleAgentLogs.setLevel(1);
            scheduleAgentLogs.setCreatedAt(LocalDateTime.now());
            scheduleAgentLogs.setState(RunState.WORKING.getCode());
            scheduleAgentLogs.insert();
        } else {
            // 更新
            scheduleAgentLogs.setMessage(runLogs.toString());
            scheduleAgentLogs.setUpdatedAt(LocalDateTime.now());
            scheduleAgentLogs.setState(success ? RunState.COMPLETE.getCode() : RunState.ERROR.getCode());
            scheduleAgentLogs.insertOrUpdate();
        }
        return scheduleAgentLogs;
    }

    /**
     * 保存运行结果到数据库
     *
     * @param canCreateEvents 是否保存结果
     * @param payload         采集到的数据内容列表
     * @param options         任务配置信息
     * @return 数据是否有变动
     */
    public JSONObject saveEvents(final Integer agentId, final Integer taskId, final Boolean canCreateEvents, final JSONObject options, final JSONArray payload) {
        JSONObject result = new JSONObject();
        List<ScheduleEvents> newEvents = new ArrayList<>();
        AtomicBoolean isChange = new AtomicBoolean(false);
        if (payload == null) {
            result.put("isChange", isChange.get());
            result.put("row", newEvents);
        }
        String mode = options.getString("mode");
        //和多少条数据对比去重
        Integer uniquenessLookBack = options.getInteger("uniqueness_look_back");

        payload.forEach(map -> {
            ScheduleEvents eventAdd = new ScheduleEvents();
            eventAdd.setAgentId(agentId);
            eventAdd.setTaskId(taskId);
            eventAdd.setPayload(JSON.toJSONString(map));
            eventAdd.setCreatedAt(LocalDateTime.now());
            //是否保存事件
            if (canCreateEvents) {
                // on_change 表示数据发生改变的时候才插入，即不产生重复数据
                if (StringUtil.isNotEmpty(mode)) {
                    if (Objects.equals(mode, "on_change")) {
                        if (!eventsService.exists(agentId, uniquenessLookBack, eventAdd.getPayload())) {
                            isChange.set(true);
                            eventAdd.insert();
                            newEvents.add(eventAdd);
                        }
                    } else {
                        isChange.set(true);
                        eventAdd.insert();
                        newEvents.add(eventAdd);
                    }
                } else {
                    if ((!eventsService.exists(agentId, uniquenessLookBack, eventAdd.getPayload()))) {
                        isChange.set(true);
                        eventAdd.insert();
                        newEvents.add(eventAdd);
                    }
                }
            }
        });
        result.put("isChange", isChange.get());
        result.put("row", newEvents);
        return result;
    }
}
