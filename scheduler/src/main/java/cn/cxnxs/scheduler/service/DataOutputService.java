package cn.cxnxs.scheduler.service;

import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.entity.ScheduleEvents;
import cn.cxnxs.scheduler.exception.AgentNotFoundException;
import cn.cxnxs.scheduler.exception.IllegalOptionException;
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
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class DataOutputService {

    @Autowired
    private EventsServiceImpl eventsService;

    @Autowired
    private AgentServiceImpl agentService;

    /**
     * 获取输出数据
     *
     * @param agentId 任务id
     */
    public JSONObject getOutputData(Integer agentId, String secret) {
        ScheduleAgent agent = agentService.getById(agentId);
        if (agent == null) {
            throw new AgentNotFoundException("任务不存在");
        }
        // 校验密码
        JSONObject options = JSONObject.parseObject(agent.getOptions());
        JSONArray secrets = options.getJSONArray("secrets");
        boolean flag = false;
        for (int i = 0; i < secrets.size(); i++) {
            if (Objects.equals(secrets.getString(i), secret)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new IllegalOptionException("密码不正确");
        }

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
    public String getRssData(Integer agentId, String secret) throws FeedException {
        JSONObject outputData = this.getOutputData(agentId, secret);
        SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("rss_2.0");
        feed.setTitle(outputData.getString("title"));
        feed.setLink(outputData.getString("link"));
        SyndImage icon = new SyndImageImpl();
        icon.setUrl(outputData.getString("icon"));
        icon.setLink(outputData.getString("icon"));
        icon.setDescription("图标");
        icon.setWidth(50);
        icon.setHeight(50);
        feed.setIcon(icon);
        feed.setDescription(outputData.getString("description"));

        JSONArray items = outputData.getJSONArray("item");
        List<SyndEntry> entries = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            JSONObject item = items.getJSONObject(i);
            SyndEntry entry = new SyndEntryImpl();
            entry.setTitle(item.getString("title"));
            entry.setLink(item.getString("link"));
            entry.setPublishedDate(item.getDate("pubDate"));
            if (item.containsKey("description")) {
                SyndContentImpl syndContent = new SyndContentImpl();
                syndContent.setValue(item.getString("description"));
                entry.setDescription(syndContent);
            }
            if (item.containsKey("content")) {
                SyndContentImpl content = new SyndContentImpl();
                content.setValue(item.getString("content"));
                entry.setContents(Collections.singletonList(content));
            }
            entries.add(entry);
        }
        feed.setEntries(entries);
        return new SyndFeedOutput().outputString(feed);
    }
}
