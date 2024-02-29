package cn.cxnxs.scheduler.core.agents;

import cn.cxnxs.scheduler.core.Event;
import cn.cxnxs.scheduler.core.MultipleSourcesAgent;
import cn.cxnxs.scheduler.core.RunResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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
    public void start(RunResult runResult) throws Exception {
        long start = System.currentTimeMillis();
        JSONArray result = new JSONArray();
        List<Event> events = getEvents();
        // 数据源
        List<JSONObject> list = events.stream().map(Event::getPayload).collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(events)) {
            runResult.info("输入数据：{}", events);
            JSONObject options = getOptions();
            JSONObject templateOption = options.getJSONObject("template");
            JSONObject itemOption = templateOption.getJSONObject("item");
            Template template = this.buildTemplate(itemOption.toJSONString());
            StringWriter out = new StringWriter();
            List<JSONObject> items = new ArrayList<>();
            for (JSONObject jsonObject : list) {
                // 清空 StringWriter
                out.getBuffer().setLength(0);
                template.process(jsonObject, out);
                items.add(JSONObject.parseObject(out.toString()));
            }
            templateOption.put("item", items);
            result.add(templateOption);
            // 将内容返回
            runResult.log("解析完成！用时：{}ms,最终解析结果：\n{}", System.currentTimeMillis() - start, result.toJSONString());
            runResult.setPayload(result);
        }
    }
}
