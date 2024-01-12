package cn.cxnxs.scheduler.core.agents.parser;

import cn.cxnxs.scheduler.core.http.ContentType;
import cn.cxnxs.scheduler.exception.IllegalOptionException;
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
    public List<Map<String, String>> parse(JSONObject extract, String payload) {
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
                    List<String> res = this.cssParse(doc, extractOptions);
                    if (size != 0 && size != res.size()) {
                        throw new IllegalOptionException("抓取的数据条数不一致");
                    }
                    size = res.size();
                    resultData.put(extractKey, res);
                } else if (TYPE_XPATH.equals(key)) {
                    List<String> res = this.xpathParse(doc, extractOptions);
                    if (size != 0 && size != res.size()) {
                        throw new IllegalOptionException("抓取的数据条数不一致");
                    }
                    size = res.size();
                    resultData.put(extractKey, res);
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
        Elements elements = doc.select(extractOptions.getString("css"));
        if (elements != null && !elements.isEmpty()) {
            for (Element element : elements) {
                result.add(this.getContent(element, extractOptions.getString("value")));
            }
        }
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


    private List<Map<String, String>> format(Map<String, List<String>> resultData, JSONObject extract) {
        List<Map<String, String>> result = new ArrayList<>();
        boolean flag = true;
        Set<String> keySet = extract.keySet();
        for (String key : keySet) {
            List<String> dataList = resultData.get(key);
            for (int i = 0; i < dataList.size(); i++) {
                if (flag) {
                    Map<String, String> formatDataMap = new HashMap<>();
                    formatDataMap.put(key, dataList.get(i));
                    result.add(formatDataMap);
                } else {
                    Map<String, String> formatDataMap = result.get(i);
                    formatDataMap.put(key, dataList.get(i));
                }

            }
            flag = false;
        }
        return result;
    }
}
