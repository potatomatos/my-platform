package cn.cxnxs.scheduler.core.agents.parser;


import cn.cxnxs.scheduler.core.agents.http.ContentType;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>XML解析器</p>
 *
 * @author mengjinyuan
 * @date 2021-02-01 22:38
 **/
@Slf4j
public class XMLParser extends HTMLParser {

    public XMLParser(ContentType contentType, String name) {
        super(contentType, name);
    }
}
