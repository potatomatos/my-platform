package cn.cxnxs.scheduler.core.agents.parser;


import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.core.http.ContentType;
import cn.cxnxs.scheduler.exception.WebsiteParseException;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
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

    protected RunResult runResult;

    public WebSiteContentParser(ContentType contentType, String name) {
        this.contentType = contentType;
        this.name = name;
        WebSiteParserFactory.register(contentType, this);
    }

    private WebSiteContentParser() {
    }

    public final JSONArray parse(JSONObject extract, String payload, RunResult runResult) {
        this.runResult = runResult;
        return this.parse(extract, payload);
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

    /**
     * 校验每个选择器个数是否一致，以及是否是重复行
     */
    protected boolean checkSize(int size, List<String> values, boolean repeat) {
        if (repeat) {
            if (values.size() > 1) {
                throw new WebsiteParseException("配置了可重复，抓取结果只能有一条！");
            }
        } else {
            if (size != 0 && size != values.size()) {
                throw new WebsiteParseException("抓取的数据条数不一致");
            }
        }
        return true;
    }

    protected JSONArray format(Map<String, List<String>> resultData, JSONObject extract) {
        JSONArray result = new JSONArray();
        //找出所有的可重复值
        Map<String, String> keysWithRepeat = new HashMap<>();
        List<String> keysToRemove = new ArrayList<>();
        extract.entrySet().stream()
                .filter(entry -> entry.getValue() instanceof JSONObject)
                .forEach(entry -> {
                    boolean repeat = ((JSONObject) entry.getValue()).getBooleanValue("repeat");
                    if (repeat) {
                        List<String> values = resultData.get(entry.getKey());
                        String value = "";
                        if (!CollectionUtils.isEmpty(values)) {
                            value = values.get(0);
                        }
                        keysWithRepeat.put(entry.getKey(), value);
                        // 保存要删除的键
                        keysToRemove.add(entry.getKey());
                    }
                });
        // 从数据行中删除重复键
        keysToRemove.forEach(extract::remove);
        keysToRemove.forEach(resultData::remove);
        boolean flag = true;
        for (Map.Entry<String, List<String>> entry : resultData.entrySet()) {
            String key = entry.getKey();
            List<String> dataList = entry.getValue();
            for (int i = 0; i < dataList.size(); i++) {
                if (flag) {
                    JSONObject formatDataMap = new JSONObject();
                    formatDataMap.put(key, dataList.get(i));
                    formatDataMap.putAll(keysWithRepeat);
                    result.add(formatDataMap);
                } else {
                    JSONObject formatDataMap = result.getJSONObject(i);
                    formatDataMap.put(key, dataList.get(i));
                }
            }
            flag = false;
        }
        return result;
    }
}
