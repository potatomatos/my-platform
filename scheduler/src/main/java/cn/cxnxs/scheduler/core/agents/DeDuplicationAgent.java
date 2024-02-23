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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * 数据去重任务
 */
@Component
@Scope("prototype")
@Slf4j
public class DeDuplicationAgent extends MultipleSourcesAgent {
    @Override
    public void start(RunResult runResult) {
        long start = System.currentTimeMillis();
        List<Event> events = getEvents();
        if (!CollectionUtils.isEmpty(events)) {
            runResult.info("输入数据：{}", events);
            JSONObject options = getOptions();
            // 去重的字段名
            String property = options.getString("property");
            runResult.info("去重字段配置：property={}", property);
            Map<String, Boolean> dupConMap = new HashMap<>();
            List<JSONObject> list = events.stream().map(Event::getPayload).collect(Collectors.toList());
            JSONArray result = new JSONArray();
            // 获取需要去重的字段名
            Pattern pattern = Pattern.compile("\\$\\{\\s*(.*?)\\s*\\}");
            Matcher matcher = pattern.matcher(property);
            String key = null;
            if (matcher.find()) {
                key = matcher.group(1);
            }

            if (StringUtil.isNotEmpty(key)) {
                for (JSONObject json : list) {
                    ReadContext context = JsonPath.parse(json);
                    // 通过jsonpath获取到内容
                    String value = context.read("$." + key);
                    if (StringUtil.isNotEmpty(value) && !dupConMap.containsKey(value)) {
                        dupConMap.put(value, true);
                        result.add(json);
                    }
                }
                // 将内容返回
                runResult.log("解析完成！用时：{}ms,数据大小：{}，最终解析结果：\n{}", System.currentTimeMillis() - start, result.size(), result.toJSONString());
                runResult.setPayload(result);
            } else {
                runResult.error("无法解析去重字段：", property);
            }
        }
    }
}
