package cn.cxnxs.scheduler.core.agents.parser;


import cn.cxnxs.scheduler.core.http.ContentType;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * 网页内容处理器
 *
 * @author potatomato
 */
@Slf4j
public abstract class WebSiteContentParser {

    protected ContentType contentType;

    protected String name;

    public WebSiteContentParser(ContentType contentType, String name) {
        this.contentType = contentType;
        this.name = name;
        WebSiteParserFactory.register(contentType, this);
    }

    private WebSiteContentParser() {
    }

    /**
     * 根据配置解析网站内容
     *
     * @param extract 提取配置
     * @param payload 提取内容
     * @return 解析成列表返回
     */
    public abstract List<Map<String, String>> parse(JSONObject extract, String payload);


    public ContentType getContentType() {
        return this.contentType;
    }

    public String getName() {
        return this.name;
    }
}
