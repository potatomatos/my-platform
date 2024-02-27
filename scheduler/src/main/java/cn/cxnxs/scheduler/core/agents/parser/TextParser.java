package cn.cxnxs.scheduler.core.agents.parser;


import cn.cxnxs.scheduler.core.http.ContentType;
import cn.cxnxs.scheduler.exception.IllegalOptionException;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>XML解析器</p>
 *
 * @author mengjinyuan
 * @date 2021-02-01 22:38
 **/
@Slf4j
public class TextParser extends WebSiteContentParser {

    public TextParser(ContentType contentType, String name) {
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
        for (String extractKey : extractKeys) {
            JSONObject extractOptions = extract.getJSONObject(extractKey);
            String regexp = extractOptions.getString("regexp");
            Integer index = extractOptions.getInteger("index");
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(payload);
            List<String> values = new ArrayList<>();
            if (index == 0) {
                while (matcher.find()) {
                    values.add(matcher.group());
                }
            } else {
                if (matcher.find()) {
                    values.add(matcher.group(index));
                }
            }

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
