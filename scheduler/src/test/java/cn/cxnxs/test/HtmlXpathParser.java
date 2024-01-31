package cn.cxnxs.test;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpHeader;
import com.arronlong.httpclientutil.common.HttpMethods;
import com.arronlong.httpclientutil.common.HttpResult;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import us.codecraft.xsoup.Xsoup;

public class HtmlXpathParser {

    public static void main(String[] args) throws Exception {
        HttpHeader httpHeader = HttpHeader.custom().userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.81 Safari/537.36 SE 2.X MetaSr 1.0");
        Header[] headers = httpHeader.build();
        HCB hcb = HCB.custom().retry(5);
        HttpClient client = hcb.build();
        HttpConfig config = HttpConfig.custom()
                .url("https://www.cnblogs.com/mokou")
                .headers(headers)
                .client(client)
                .encoding("utf-8")
                .timeout(5000);
        config.method(HttpMethods.GET);
        HttpResult respResult = HttpClientUtil.sendAndGetResp(config);
        Document doc = Jsoup.parse(respResult.getResult());

        // 使用Jsoup-XPath提取需要的内容
        Elements titles = Xsoup.compile("//*[@id=\"mainContent\"]/div/div/div[2]/a/span").evaluate(doc).getElements();
        for (int i = 0; i < titles.size(); i++) {
            System.out.println("Title " + i + ": " + titles.get(i).text());
        }
    }
}
