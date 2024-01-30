package cn.cxnxs.scheduler.core.agents;


import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.scheduler.core.AbstractAgent;
import cn.cxnxs.scheduler.core.Event;
import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.core.agents.parser.WebSiteContentParser;
import cn.cxnxs.scheduler.core.agents.parser.WebSiteParserFactory;
import cn.cxnxs.scheduler.core.http.ContentType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * <p>网站代理</p>
 *
 * @author mengjinyuan
 * @date 2021-01-18 14:02
 **/
@Component
@Scope("prototype")
@Slf4j
public class WebsiteAgent extends AbstractAgent {

    @Override
    public void start(Event event, RunResult runResult) throws Exception {
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
                if (StringUtil.isNotEmpty(this.getOptions().getString("sslpv"))) {
                    hcb.sslpv(this.getOptions().getString("sslpv"));
                }
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
        runResult.info("-----------请求参数-----------");
        runResult.info(this.getOptions().toJSONString());
        runResult.info("-----------------------------");
        HttpResult respResult = HttpClientUtil.sendAndGetResp(config);

        //处理返回结果
        WebSiteContentParser webSiteContentParser = WebSiteParserFactory.getParser(ContentType.valueOf(this.getOptions().getString("type").toUpperCase(Locale.ENGLISH)));
        JSONArray maps = webSiteContentParser.parse(this.getOptions().getJSONObject("extract"), respResult.getResult(), runResult);
        runResult.log("数据大小：{}，最终解析结果：\n{}", maps.size(), maps.toString(SerializerFeature.PrettyFormat));
        runResult.setPayload(maps);
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
