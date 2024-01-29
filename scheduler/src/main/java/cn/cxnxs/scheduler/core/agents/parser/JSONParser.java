package cn.cxnxs.scheduler.core.agents.parser;

import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.core.http.ContentType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>XML解析器</p>
 *
 * @author mengjinyuan
 * @date 2021-02-01 22:38
 **/
@Slf4j
public class JSONParser extends WebSiteContentParser {
    public JSONParser(ContentType contentType, String name) {
        super(contentType, name);
    }

    @Override
    public JSONArray parse(JSONObject extract, String payload) {
        return null;
    }
}
