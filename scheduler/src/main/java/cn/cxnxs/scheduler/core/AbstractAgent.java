package cn.cxnxs.scheduler.core;

import cn.cxnxs.scheduler.enums.OptionConstants;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

@Slf4j
@Getter
@Setter
public abstract class AbstractAgent implements IAgent {

    /**
     * 服务配置
     */
    protected JSONObject options;

    /**
     * 服务名称
     */
    protected String name;

    protected Integer id;

    @Override
    public RunResult runAgent() {
        Thread thread = Thread.currentThread();
        RunResult runResult = new RunResult(new JSONArray(), RunLogs.create(thread.getId() + "-" + thread.getName()));
        try {
            // 开始前的一些操作
            this.preStart(runResult);
            this.start(runResult);
            runResult.setSuccess(true);
            runResult.setPayload(this.formatWithTemplate(runResult.getPayload()));
            runResult.info("运行结束");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            runResult.error(e.getMessage());
            runResult.setSuccess(false);
        }
        return runResult;
    }

    /**
     * 根据配置中的模板返回
     *
     * @param sources
     */
    private JSONArray formatWithTemplate(JSONArray sources) throws IOException, TemplateException {
        if (this.options.containsKey("template") && !CollectionUtils.isEmpty(sources)) {
            JSONArray result = new JSONArray();
            String templateStr = this.options.getString("template");
            Template template = this.buildTemplate(templateStr);
            StringWriter out = new StringWriter();
            for (int i = 0; i < sources.size(); i++) {
                // 清空 StringWriter
                out.getBuffer().setLength(0);
                JSONObject jsonObject = sources.getJSONObject(i);
                jsonObject.put("_this_", this.options);
                template.process(jsonObject, out);
                result.add(JSONObject.parseObject(out.toString()));
            }
            return result;
        }
        return sources;
    }


    protected Template buildTemplate(String templateStr) throws IOException {
        // 将自定义函数注入到模板里
        templateStr = OptionConstants.INCREMENT
                + OptionConstants.DECREMENT
                + OptionConstants.CONCAT
                + templateStr;
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        return new Template("template", new StringReader(templateStr), cfg);
    }

    @Override
    public IAgent option(JSONObject options) {
        this.options = options;
        return this;
    }

    @Override
    public JSONObject getOptions() {
        return this.options;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public abstract void start(RunResult runResult) throws Exception;


    public abstract void preStart(RunResult runResult) throws Exception;

}
