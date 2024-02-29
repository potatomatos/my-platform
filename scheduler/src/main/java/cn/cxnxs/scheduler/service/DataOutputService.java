package cn.cxnxs.scheduler.service;

import cn.cxnxs.scheduler.entity.ScheduleEvents;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class DataOutputService {

    @Autowired
    private EventsServiceImpl eventsService;

    /**
     * 获取输出数据
     *
     * @param agentId 任务id
     */
    public JSONObject getOutputData(Integer agentId) {
        // 直接获取最新的数据
        ScheduleEvents scheduleEvent = eventsService.getOne(Wrappers.lambdaQuery(ScheduleEvents.class)
                .eq(ScheduleEvents::getAgentId, agentId)
                .orderByDesc(ScheduleEvents::getCreatedAt).last(" limit 1")
        );
        if (Objects.nonNull(scheduleEvent)) {
            return JSONObject.parseObject(scheduleEvent.getPayload());
        } else {
            return new JSONObject();
        }
    }

    /**
     * 获取rss数据
     */
    public String getRssData(Integer agentId) throws FeedException {
        JSONObject outputData = this.getOutputData(agentId);
        SyndFeed feed = JSONObject.parseObject(outputData.toJSONString(), SyndFeedImpl.class);
        JSONArray items = outputData.getJSONArray("item");
        List<SyndEntry> entries = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            JSONObject item = items.getJSONObject(i);
            SyndEntry entry = new SyndEntryImpl();
            entry.setTitle(item.getString("title"));
            entry.setLink(item.getString("link"));
            entry.setPublishedDate(item.getDate("pubDate"));
            SyndContentImpl syndContent = new SyndContentImpl();
            syndContent.setValue(item.getString("description"));
            entry.setDescription(syndContent);
            entries.add(entry);
        }
        feed.setEntries(entries);
        return new SyndFeedOutput().outputString(feed);
    }
}
