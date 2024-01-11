package cn.cxnxs.scheduler.core.agents.parser;


import cn.cxnxs.scheduler.core.http.ContentType;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * <p>XML解析器</p>
 *
 * @author mengjinyuan
 * @date 2021-02-01 22:38
 **/
public class XMLParser extends WebSiteContentParser {
    public XMLParser(ContentType contentType, String name) {
        super(contentType, name);
    }

    @Override
    public List<Map<String, String>> parse(JSONObject extract, String payload) {
        return null;
    }
}
