package cn.cxnxs.scheduler.core.agents;

import cn.cxnxs.scheduler.core.Event;
import cn.cxnxs.scheduler.core.MultipleSourcesAgent;
import cn.cxnxs.scheduler.core.RunResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据输出
 */
@Component
@Scope("prototype")
@Slf4j
public class DataOutputAgent extends MultipleSourcesAgent {

    @Override
    public void start(RunResult runResult) throws IOException, TemplateException {
        long start = System.currentTimeMillis();
        JSONArray result = new JSONArray();
        List<Event> events = getEvents();
        // 数据源
        List<JSONObject> list = events.stream().map(Event::getPayload).collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(events)) {
            runResult.info("输入数据：{}", events);
            JSONObject options = getOptions();
            JSONObject bodyOption = options.getJSONObject("body");
            JSONObject itemOption = bodyOption.getJSONObject("item");
            List<JSONObject> items = new ArrayList<>();
            for (JSONObject jsonObject : list) {
                JSONObject item = new JSONObject();
                Template tlp;
                for (String itemKey : itemOption.keySet()) {
                    String itemValue = itemOption.getString(itemKey);
                    tlp = this.buildTemplate(itemValue);
                    StringWriter out = new StringWriter();
                    tlp.process(jsonObject, out);
                    item.put(itemKey, out.toString());
                }
                items.add(item);
            }
            bodyOption.put("item", items);
            result.add(bodyOption);
            // 将内容返回
            runResult.log("解析完成！用时：{}ms,最终解析结果：\n{}", System.currentTimeMillis() - start, result.toJSONString());
            runResult.setPayload(result);
        }
    }
}
