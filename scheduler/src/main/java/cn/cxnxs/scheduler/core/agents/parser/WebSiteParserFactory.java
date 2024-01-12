package cn.cxnxs.scheduler.core.agents.parser;


import cn.cxnxs.scheduler.core.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>解析器工厂</p>
 *
 * @author mengjinyuan
 * @date 2021-01-24 00:04
 **/
@Slf4j
public class WebSiteParserFactory {

    private static final ConcurrentHashMap<ContentType, WebSiteContentParser> webSiteContentParserConcurrentHashMap = new ConcurrentHashMap<>();

    public static void register(ContentType contentType, WebSiteContentParser webSiteContentParser) {
        log.info("register parser,type:{},parser:{}", contentType, webSiteContentParser);
        if (webSiteContentParserConcurrentHashMap.containsKey(contentType)) {
            log.warn("contentType [{}] is exist", contentType);
        } else {
            webSiteContentParserConcurrentHashMap.put(contentType, webSiteContentParser);
        }
    }

    public static WebSiteContentParser getParser(ContentType type) {
        return webSiteContentParserConcurrentHashMap.get(type);
    }

}
