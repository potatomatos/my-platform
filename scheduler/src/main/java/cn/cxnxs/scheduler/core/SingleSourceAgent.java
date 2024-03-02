package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONObject;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Objects;

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
    public void preStart(RunResult runResult) throws TemplateException, IOException {
        this.replacePlaceHolder(runResult);
    }

    /**
     * 使用event中的数据中替换掉配置中的#{}占位符
     *
     * @param runResult 记录日志
     */
    public final void replacePlaceHolder(RunResult runResult) throws TemplateException, IOException {
        if (!Objects.isNull(event) && !event.getPayload().isEmpty() && !Objects.isNull(this.getOptions())) {
            runResult.info("入参数据：{}", event);
            runResult.info("-------开始替换配置占位符------");
            JSONObject options = getOptions();
            JSONObject template = new JSONObject();
            boolean hasTemplate = options.containsKey("template");
            // template节点不替换
            if (hasTemplate) {
                template = options.getJSONObject("template");
                options.remove("template");
            }
            String optionsStr = options.toJSONString();
            JSONObject ev = event.getPayload();
            ev.put("_this_", options);
            Template tlp = this.buildTemplate(optionsStr);
            // 渲染模板
            StringWriter out = new StringWriter();
            tlp.process(ev, out);
            options = JSONObject.parseObject(out.toString());
            if (hasTemplate) {
                options.put("template", template);
            }
            setOptions(options);
        }
    }
}
