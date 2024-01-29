package cn.cxnxs.scheduler.core.agents.parser;


import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.core.http.ContentType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * 网页内容处理器
 *
 * @author potatomato
 */
@Slf4j
public abstract class WebSiteContentParser {

    protected ContentType contentType;

    protected String name;

    protected RunResult runResult;

    public WebSiteContentParser(ContentType contentType, String name) {
        this.contentType = contentType;
        this.name = name;
        WebSiteParserFactory.register(contentType, this);
    }

    private WebSiteContentParser() {
    }

    public final JSONArray parse(JSONObject extract, String payload,RunResult runResult){
        this.runResult = runResult;
        return this.parse(extract,payload);
    }
    /**
     * 根据配置解析网站内容
     *
     * @param extract 提取配置
     * @param payload 提取内容
     * @return 解析成列表返回
     */
    protected abstract JSONArray parse(JSONObject extract, String payload);


    public ContentType getContentType() {
        return this.contentType;
    }

    public String getName() {
        return this.name;
    }
}
