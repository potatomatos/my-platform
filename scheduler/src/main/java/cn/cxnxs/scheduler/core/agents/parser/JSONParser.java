package cn.cxnxs.scheduler.core.agents.parser;

import cn.cxnxs.scheduler.core.http.ContentType;
import cn.cxnxs.scheduler.exception.IllegalOptionException;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        if (extract == null) {
            throw new IllegalOptionException("数据提取配置为空");
        }
        Set<String> extractKeys = extract.keySet();
        Map<String, List<String>> resultData = new HashMap<>();
        int size = 0;
        ReadContext context = JsonPath.parse(payload, Configuration.defaultConfiguration());
        for (String extractKey : extractKeys) {
            JSONObject extractOptions = extract.getJSONObject(extractKey);
            String path = extractOptions.getString("path");
            List<String> values = context.read("$." + path);
            boolean repeat = extractOptions.getBooleanValue("repeat");
            if (checkSize(size, values, repeat)) {
                if (!repeat) {
                    size = values.size();
                }
                resultData.put(extractKey, values);
            }

        }
        return this.format(resultData, extract);
    }
}
