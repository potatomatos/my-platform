package cn.cxnxs.scheduler.core.agents;

import cn.cxnxs.scheduler.core.Event;
import cn.cxnxs.scheduler.core.MultipleSourcesAgent;
import cn.cxnxs.scheduler.core.RunResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
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
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 数据过滤任务，配置格式：
 * {
 * "expected_update_period_in_days": "2",
 * "rules": [
 * {
 * "type": "regex",
 * "value": "rain|storm",
 * "path": "conditions"
 * }
 * ]
 * }
 */
@Component
@Scope("prototype")
@Slf4j
public class TriggerAgent extends MultipleSourcesAgent {
    @Override
    public void start(RunResult runResult) throws IOException, TemplateException {
        long start = System.currentTimeMillis();
        List<Event> events = getEvents();
        if (!CollectionUtils.isEmpty(events)) {
            runResult.info("输入数据：{}", events);
            JSONObject options = getOptions();
            // 等于1时，所有规则都满足才通过
            Integer mustMatch = options.getInteger("must_match");
            // 匹配规则
            List<JSONObject> rules = options.getJSONArray("rules").stream().map(item -> JSONObject.parseObject(JSON.toJSONString(item))).collect(Collectors.toList());

            // 数据源
            List<JSONObject> list = events.stream().map(Event::getPayload).collect(Collectors.toList());
            JSONArray result = new JSONArray();
            for (JSONObject jsonObject : list) {
                List<Boolean> checkResult = new ArrayList<>();
                ReadContext context = JsonPath.parse(jsonObject);
                // 匹配规则
                for (JSONObject rule : rules) {
                    String type = rule.getString("type");
                    String value = rule.getString("value");
                    String path = rule.getString("path");
                    // 通过jsonpath获取到内容
                    String data = context.read("$." + path);
                    // 正则的方式
                    if (Objects.equals(type, "regex")) {
                        checkResult.add(regexCheck(data, value));
                    } else if (Objects.equals(type, "!regex")) {
                        checkResult.add(!regexCheck(data, value));
                    } else {
                        Template template = null;
                        if (Objects.equals(type, "field<value")) {
                            template = this.buildTemplate("${(" + data + "<" + value + ")?c}");
                        } else if (Objects.equals(type, "field<=value")) {
                            template = this.buildTemplate("${(" + data + "<=" + value + ")?c}");
                        } else if (Objects.equals(type, "field==value")) {
                            template = this.buildTemplate("${(\"" + data + "\"==\"" + value + "\")?c}");
                        } else if (Objects.equals(type, "field!=value")) {
                            template = this.buildTemplate("${(" + data + "!=" + value + ")?c}");
                        } else if (Objects.equals(type, "field>=value")) {
                            template = this.buildTemplate("${(" + data + ">=" + value + ")?c}");
                        } else if (Objects.equals(type, "field>value")) {
                            template = this.buildTemplate("${(" + data + ">" + value + ")?c}");
                        } else {
                            runResult.error("规则配置有误：{}", rule);
                        }
                        if (template != null) {
                            StringWriter out = new StringWriter();
                            template.process(jsonObject, out);
                            checkResult.add(Boolean.parseBoolean(out.toString()));
                        }
                    }
                }

                // 与关系
                if (Objects.equals(mustMatch, 1)) {
                    if (checkResult.stream().allMatch(Boolean::booleanValue)) {
                        result.add(jsonObject);
                    }
                } else {
                    // 或者关系
                    if (checkResult.stream().anyMatch(Boolean::booleanValue)) {
                        result.add(jsonObject);
                    }
                }
            }

            // 将内容返回
            runResult.log("解析完成！用时：{}ms,数据大小：{}，最终解析结果：\n{}", System.currentTimeMillis() - start, result.size(), result.toJSONString());
            runResult.setPayload(result);
        }
    }

    /**
     * 正则匹配
     *
     * @param value
     * @param regex
     * @return
     */
    public Boolean regexCheck(String value, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
