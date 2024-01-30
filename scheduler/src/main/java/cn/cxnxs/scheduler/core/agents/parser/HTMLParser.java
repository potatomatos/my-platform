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
        List<String> res = new ArrayList<>();
        int size = 0;
        for (String extractKey : extractKeys) {
            JSONObject extractOptions = extract.getJSONObject(extractKey);
            Set<String> keys = extractOptions.keySet();
            for (String key : keys) {
                res.clear();
                if (TYPE_CSS.equals(key)) {
                    res = this.cssParse(doc, extractOptions);
                    size = res.size();
                    resultData.put(extractKey, res);
                } else if (TYPE_XPATH.equals(key)) {
                    res = this.xpathParse(doc, extractOptions);
                    assert res != null;
                    size = res.size();
                    resultData.put(extractKey, res);
                }
                if (size != 0 && size != res.size()) {
                    throw new WebsiteParseException("抓取的数据条数不一致");
                }
            }
        }
        return this.format(resultData, extract);
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
                result.add(this.getContent(element, extractOptions.getString("value")));
            }
        }
        runResult.info("解析数据结果：{}", result);
        return result;
    }

    /**
     * xpath 解析
     *
     * @param doc 解析内容
     * @return 解析结果
     */
    private List<String> xpathParse(Document doc, JSONObject extractOptions) {
        return null;
    }

    private String getContent(Element element, String value) {
        if (value != null) {
            if ("string()".equals(value)) {
                return element.text();
            } else if (value.contains("@")) {
                return element.attr(value.substring(1));
            }
        }
        return null;
    }


    private JSONArray format(Map<String, List<String>> resultData, JSONObject extract) {
        JSONArray result = new JSONArray();
        boolean flag = true;
        Set<String> keySet = extract.keySet();
        for (String key : keySet) {
            List<String> dataList = resultData.get(key);
            for (int i = 0; i < dataList.size(); i++) {
                if (flag) {
                    JSONObject formatDataMap = new JSONObject();
                    formatDataMap.put(key, dataList.get(i));
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
