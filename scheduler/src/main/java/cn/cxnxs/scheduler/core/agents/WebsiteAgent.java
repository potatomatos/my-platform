package cn.cxnxs.scheduler.core.agents;


import cn.cxnxs.scheduler.core.AbstractAgent;
import cn.cxnxs.scheduler.core.Event;
import cn.cxnxs.scheduler.core.agents.parser.WebSiteContentParser;
import cn.cxnxs.scheduler.core.agents.parser.WebSiteParserFactory;
import cn.cxnxs.scheduler.core.http.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.*;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * <p>网站代理</p>
 *
 * @author mengjinyuan
 * @date 2021-01-18 14:02
 **/
@Component
@Scope("prototype")
public class WebsiteAgent extends AbstractAgent {

    private static final Logger logger = LoggerFactory.getLogger(WebsiteAgent.class);

    @Override
    public List<Map<String, String>> collect(Event event) throws HttpProcessException {

        //请求地址
        String url = this.getOptions().getString("url");
        //插件式配置Header（各种header信息、自定义header）
        HttpHeader httpHeader = HttpHeader.custom().userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.81 Safari/537.36 SE 2.X MetaSr 1.0");
        if (this.getOptions().get("headers") != null) {
            JSONObject headers = this.getOptions().getJSONObject("headers");
            for (String key : headers.keySet()) {
                httpHeader.other(key, headers.getString(key));
            }
        }
        Header[] headers = httpHeader.build();
        //重试5次
        HCB hcb = HCB.custom().retry(5);
        //是否绕过ssl
        if (this.getOptions().get("disable_ssl_verification") != null) {
            if (this.getOptions().getBoolean("disable_ssl_verification")) {
                hcb.ssl();
            }
        }
        HttpClient client = hcb.build();
        //获取返回的cookie
        HttpCookies cookies = HttpCookies.custom();
        //插件式配置请求参数（网址、请求参数、编码、client）
        HttpConfig config = HttpConfig.custom()
                .url(url)
                .headers(headers)
                .client(client)
                .encoding("utf-8")
                .timeout(5000).context(cookies.getContext());
        //请求方式判断
        if (this.getOptions().get("method") != null) {
            if (this.getOptions().getString("method").toUpperCase().equals(HttpMethods.POST.getName())) {
                config.method(HttpMethods.POST);
                //设置请求体
                if (this.getOptions().get("data") != null) {
                    JSONObject data = this.getOptions().getJSONObject("data");
                    config.json(data.toJSONString());
                }
            } else if (this.getOptions().getString("method").toUpperCase().equals(HttpMethods.GET.getName())) {
                config.method(HttpMethods.GET);
            }
        }
        logger.info("-----------请求参数-----------");
        logger.info("-----------------------------");
        HttpResult respResult = HttpClientUtil.sendAndGetResp(config);
        logger.info("-----------------------------");

        //处理返回结果
        WebSiteContentParser webSiteContentParser = WebSiteParserFactory.getParser(ContentType.valueOf(this.getOptions().getString("type").toUpperCase(Locale.ENGLISH)));
        List<Map<String, String>> maps = webSiteContentParser.parse(this.getOptions().getJSONObject("extract"), respResult.getResult());
        logger.debug("数据大小：{}，解析结果：{}", maps.size(), JSON.toJSONString(maps, SerializerFeature.PrettyFormat));
        return maps;
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public WebsiteAgent option(JSONObject options) {
        this.setOptions(options);
        return this;
    }
}
