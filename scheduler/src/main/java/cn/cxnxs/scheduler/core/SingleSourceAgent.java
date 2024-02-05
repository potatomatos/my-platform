package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h2>处理单个event的任务抽象类</h2>
 *
 * @author mengjinyuan
 * @date 2021-01-21 11:08
 **/
@Slf4j
@Getter
@Setter
public abstract class SingleSourceAgent extends AbstractAgent {

    /**
     * 事件
     */
    private Event event;


    @Override
    public void preStart(RunResult runResult) {
        this.replacePlaceHolder(runResult);
    }

    /**
     * 使用event中的数据中替换掉配置中的#{}占位符
     *
     * @param runResult 记录日志
     */
    public final void replacePlaceHolder(RunResult runResult) {
        if (!Objects.isNull(event) && !event.getPayload().isEmpty() && !Objects.isNull(this.getOptions())) {
            runResult.info("入参数据：{}", event);
            runResult.info("-------开始替换配置占位符------");
            String optionsStr = getOptions().toJSONString();
            Pattern pattern = Pattern.compile("#\\{\\s*(.*?)\\s*\\}");
            Matcher matcher = pattern.matcher(optionsStr);
            List<String> placeHolderList = new ArrayList<>();
            List<String> keyList = new ArrayList<>();
            while (matcher.find()) {
                // 找出占位符88
                placeHolderList.add(matcher.group(0));
                keyList.add(matcher.group(1));
            }
            JSONObject ev = event.getPayload();
            ReadContext context = JsonPath.parse(ev);
            // 替换占位符的值
            for (int i = 0; i < placeHolderList.size(); i++) {
                String value = context.read("$." + keyList.get(i));
                optionsStr = optionsStr.replace(placeHolderList.get(i), value);
            }
            setOptions(JSONObject.parseObject(optionsStr));
        }
    }
}
