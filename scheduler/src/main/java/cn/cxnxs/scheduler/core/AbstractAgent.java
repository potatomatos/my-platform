package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONArray;
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
 * <p>代理抽象类</p>
 * 代理抽象类，实现了IAgent接口
 *
 * @author mengjinyuan
 * @date 2021-01-21 11:08
 **/
@Slf4j
@Getter
@Setter
public abstract class AbstractAgent implements IAgent {

    /**
     * 服务配置
     */
    private JSONObject options;

    /**
     * 服务名称
     */
    private String name;

    /**
     * 运行代理
     *
     * @param event 事件
     * @return 运行结果
     */
    public RunResult runAgent(Event event) {
        Thread thread = Thread.currentThread();
        RunResult runResult = new RunResult(new JSONArray(), RunLogs.create(thread.getId() + "-" + thread.getName()));
        try {
            this.replacePlaceHolder(runResult, event);
            this.start(event, runResult);
            runResult.setSuccess(true);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            runResult.error(e.getMessage());
            runResult.setSuccess(false);
        }
        return runResult;
    }

    /**
     * 抽象方法，由子类实现
     *
     * @param event     事件
     * @param runResult 运行结果
     * @throws Exception 异常
     */
    public abstract void start(Event event, RunResult runResult) throws Exception;

    /**
     * 使用event中的数据中替换掉配置中的#{}占位符
     *
     * @param runResult 记录日志
     * @param event     数据源
     */
    public final void replacePlaceHolder(RunResult runResult, Event event) {
        if (!Objects.isNull(event) && !Objects.isNull(this.getOptions())) {
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
