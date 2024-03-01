package cn.cxnxs.scheduler.core.agents;

import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.scheduler.core.Event;
import cn.cxnxs.scheduler.core.MultipleSourcesAgent;
import cn.cxnxs.scheduler.core.RunResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 数据输出
 */
@Component
@Scope("prototype")
@Slf4j
public class DataOutputAgent extends MultipleSourcesAgent {

    @Override
    public void start(RunResult runResult) {
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
            Pattern pattern = Pattern.compile("\\$\\{\\s*(.*?)\\s*\\}");
            for (JSONObject jsonObject : list) {
                JSONObject item = new JSONObject();
                for (String itemKey : itemOption.keySet()) {
                    item.put(itemKey, "");
                    String itemValue = itemOption.getString(itemKey);
                    Matcher matcher = pattern.matcher(itemValue);
                    String key = null;
                    if (matcher.find()) {
                        key = matcher.group(1);
                    }
                    if (StringUtil.isNotEmpty(key)) {
                        ReadContext context = JsonPath.parse(jsonObject);
                        // 通过jsonpath获取到内容
                        String value = context.read("$." + key);
                        item.put(itemKey, value);
                    }
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
