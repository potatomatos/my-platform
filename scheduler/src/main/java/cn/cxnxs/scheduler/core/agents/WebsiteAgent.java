package cn.cxnxs.scheduler.core.agents;


import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.core.SingleSourceAgent;
import cn.cxnxs.scheduler.core.agents.parser.WebSiteContentParser;
import cn.cxnxs.scheduler.core.agents.parser.WebSiteParserFactory;
import cn.cxnxs.scheduler.core.http.ContentType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Objects;

/**
 * <p>网站代理</p>
 *
 * @author mengjinyuan
 * @date 2021-01-18 14:02
 **/
@Component
@Scope("prototype")
@Slf4j
public class WebsiteAgent extends SingleSourceAgent {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.81 Safari/537.36 SE 2.X MetaSr 1.0";
    private static final int TIMEOUT = 5000;
    private static final int RETRY_TIMES = 5;

    @Override
    public void start(RunResult runResult) throws Exception {
        long start = System.currentTimeMillis();
        //请求地址
        String url = this.getOptions().getString("url");
        String urlFromEvent = this.getOptions().getString("url_from_event");
        if (Objects.nonNull(getEvent()) && !getEvent().getPayload().isEmpty() && Objects.nonNull(urlFromEvent)) {
            url = urlFromEvent;
        }
        if (StringUtil.isEmpty(url)) {
            return;
        }
        //插件式配置Header（各种header信息、自定义header）
        HttpHeader httpHeader = HttpHeader.custom().userAgent(USER_AGENT);
        if (this.getOptions().containsKey("headers")) {
            JSONObject headers = this.getOptions().getJSONObject("headers");
            headers.forEach((key, value) -> httpHeader.other(key, value.toString()));
        }
        Header[] headers = httpHeader.build();
        //重试5次
        HCB hcb = HCB.custom().retry(RETRY_TIMES);
        //是否绕过ssl
        if (this.getOptions().containsKey("disable_ssl_verification")) {
            if (this.getOptions().getBoolean("disable_ssl_verification")) {
                if (StringUtil.isNotEmpty(this.getOptions().getString("sslpv"))) {
                    hcb.sslpv(this.getOptions().getString("sslpv"));
                }
                hcb.ssl();
            }
        }
        // 设置代理
        if (this.getOptions().containsKey("proxy")) {
            String proxy = this.getOptions().getString("proxy");
            String proxyIP = proxy.split(":")[0];
            String proxyPort = proxy.split(":")[1];
            hcb.proxy(proxyIP, Integer.parseInt(proxyPort));
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
                .timeout(TIMEOUT).context(cookies.getContext());
        //请求方式判断
        if (this.getOptions().containsKey("method")) {
            if (this.getOptions().getString("method").equalsIgnoreCase(HttpMethods.POST.getName())) {
                config.method(HttpMethods.POST);
                //设置请求体
                if (this.getOptions().containsKey("data")) {
                    if (this.getOptions().containsKey("contentType")) {
                        if (Objects.equals("application/json", this.getOptions().getString("contentType"))) {
                            JSONObject data = this.getOptions().getJSONObject("data");
                            config.json(data.toJSONString());
                        } else {
                            JSONObject data = this.getOptions().getJSONObject("data");
                            config.map(data);
                        }
                    } else {
                        JSONObject data = this.getOptions().getJSONObject("data");
                        config.map(data);
                    }
                }
            } else if (this.getOptions().getString("method").equalsIgnoreCase(HttpMethods.GET.getName())) {
                config.method(HttpMethods.GET);
            }
        }
        // 超时时间
        if (this.getOptions().containsKey("timeout")) {
            config.timeout(this.getOptions().getInteger("timeout"));
        }
        runResult.info("-----------请求参数-----------");
        runResult.info(this.getOptions().toJSONString());
        runResult.info("-----------------------------");
        HttpResult respResult = HttpClientUtil.sendAndGetResp(config);

        //处理返回结果
        WebSiteContentParser webSiteContentParser = WebSiteParserFactory.getParser(ContentType.valueOf(this.getOptions().getString("type").toUpperCase(Locale.ENGLISH)));
        JSONArray maps = webSiteContentParser.parse(this.getOptions().getJSONObject("extract"), respResult.getResult(), runResult);
        runResult.log("解析完成！用时：{}ms,数据大小：{}，最终解析结果：\n{}", System.currentTimeMillis() - start, maps.size(), maps.toJSONString());
        runResult.setPayload(maps);
    }
}
