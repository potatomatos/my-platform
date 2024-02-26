package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONObject;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.StringReader;
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
            String optionsStr = options.toJSONString();
            JSONObject ev = event.getPayload();
            ev.put("__this__", options);

            // 创建Freemarker配置实例
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);

            // 使用StringReader从字符串创建模板
            Template template = new Template("template", new StringReader(optionsStr), cfg);

            // 渲染模板
            StringWriter out = new StringWriter();
            template.process(ev, out);

            setOptions(JSONObject.parseObject(out.toString()));
        }
    }
}
