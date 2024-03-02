package cn.cxnxs.scheduler.core.agents.parser;

import cn.cxnxs.scheduler.core.http.ContentType;
import cn.cxnxs.scheduler.exception.IllegalOptionException;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
            if ("string()".equals(value)) {
                // 本节点文本（不包括子节点）
                return element.ownText();
            } else if ("string(.)".equals(value)) {
                //本级及下级节点所有文本
                return element.text();
            } else if ("html()".equals(value)) {
                // 本节点的html内容
                return element.outerHtml();
            } else if (value.contains("@")) {
                // 获取属性
                return element.attr(value.substring(1));
            }
        }
        return null;
    }
}
