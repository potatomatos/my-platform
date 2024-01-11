package cn.cxnxs.scheduler.core.agents.parser;


import cn.cxnxs.scheduler.core.http.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>解析器工厂</p>
 *
 * @author mengjinyuan
 * @date 2021-01-24 00:04
 **/
public class WebSiteParserFactory {

    private static final Logger logger = LoggerFactory.getLogger(WebSiteParserFactory.class);
    private static final ConcurrentHashMap<ContentType, WebSiteContentParser> webSiteContentParserConcurrentHashMap = new ConcurrentHashMap<>();

    public static void register(ContentType contentType, WebSiteContentParser webSiteContentParser) {
        logger.info("register parser,type:{},parser:{}", contentType, webSiteContentParser);
        if (webSiteContentParserConcurrentHashMap.containsKey(contentType)) {
            logger.warn("contentType [{}] is exist", contentType);
        } else {
            webSiteContentParserConcurrentHashMap.put(contentType, webSiteContentParser);
        }
    }

    public static WebSiteContentParser getParser(ContentType type) {
        return webSiteContentParserConcurrentHashMap.get(type);
    }

}
