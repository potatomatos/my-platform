package cn.cxnxs.scheduler.core.agents.parser;

import cn.cxnxs.scheduler.core.http.ContentType;
import cn.cxnxs.scheduler.exception.IllegalOptionException;
import cn.cxnxs.scheduler.exception.WebsiteParseException;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;
import us.codecraft.xsoup.Xsoup;

import java.util.*;

/**
 * <p>html解析</p>
 *
 * @author mengjinyuan
 * @date 2021-01-24 00:12
 **/
@Slf4j
public class HTMLParser extends WebSiteContentParser {

    /**
     * 提取方式：css
     */
    private static final String TYPE_CSS = "css";
    /**
     * 提取方式：xpath
     */
    private static final String TYPE_XPATH = "xpath";

    public HTMLParser(ContentType contentType, String name) {
        super(contentType, name);
    }

    @Override
    public JSONArray parse(JSONObject extract, String payload) {
        if (extract == null) {
            throw new IllegalOptionException("数据提取配置为空");
        }
        Document doc = Jsoup.parse(payload);
        Set<String> extractKeys = extract.keySet();
        Map<String, List<String>> resultData = new HashMap<>();
        int size = 0;
        for (String extractKey : extractKeys) {
            JSONObject extractOptions = extract.getJSONObject(extractKey);
            Set<String> keys = extractOptions.keySet();
            for (String key : keys) {
                if (TYPE_CSS.equals(key)) {
                    List<String> values = this.cssParse(doc, extractOptions);
                    boolean repeat = extract.getJSONObject(extractKey).getBooleanValue("repeat");
                    if (checkSize(size, values, repeat)) {
                        if (!repeat) {
                            size = values.size();
                        }
                        resultData.put(extractKey, values);
                    }
                } else if (TYPE_XPATH.equals(key)) {
                    List<String> values = this.xpathParse(doc, extractOptions);
                    boolean repeat = extract.getJSONObject(extractKey).getBooleanValue("repeat");
                    if (checkSize(size, values, repeat)) {
                        if (!repeat) {
                            size = values.size();
                        }
                        resultData.put(extractKey, values);
                    }
                }
            }
        }
        return this.format(resultData, extract);
    }

    /**
     * 校验每个选择器个数是否一致，以及是否是重复行
     */
    public boolean checkSize(int size, List<String> values, boolean repeat) {
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

    /**
     * css 解析
     *
     * @param doc 解析内容
     * @return 解析结果
     */
    private List<String> cssParse(Document doc, JSONObject extractOptions) {
        List<String> result = new ArrayList<>();
        String css = extractOptions.getString("css");
        runResult.info("正在解析css选择器：{}", css);
        Elements elements = doc.select(css);
        if (elements != null && !elements.isEmpty()) {
            for (Element element : elements) {
                String value = this.getContent(element, extractOptions.getString("value"));
                result.add(Objects.isNull(value) ? "" : value);
            }
        }
        runResult.info("数据大小：{}，解析数据结果：{}", result.size(), result);
        return result;
    }

    /**
     * xpath 解析
     *
     * @param doc 解析内容
     * @return 解析结果
     */
    private List<String> xpathParse(Document doc, JSONObject extractOptions) {
        List<String> result = new ArrayList<>();
        String xpath = extractOptions.getString("xpath");
        runResult.info("正在解析xpath选择器：{}", xpath);
        Elements elements = Xsoup.compile(xpath).evaluate(doc).getElements();
        if (elements != null && !elements.isEmpty()) {
            for (Element element : elements) {
                String value = Xsoup.compile("/" + extractOptions.getString("value")).evaluate(element).get();
                result.add(Objects.isNull(value) ? "" : value);
            }
        }
        runResult.info("数据大小：{}，解析数据结果：{}", result.size(), result);
        return result;
    }

    private String getContent(Element element, String value) {
        if (value != null) {
            if ("string(.)".equals(value)) {
                return element.text();
            } else if (value.contains("@")) {
                return element.attr(value.substring(1));
            }
        }
        return null;
    }


    private JSONArray format(Map<String, List<String>> resultData, JSONObject extract) {
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
