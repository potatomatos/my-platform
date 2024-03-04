package cn.cxnxs.scheduler.core.agents.http;

import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.exception.IllegalOptionException;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpCookies;
import com.arronlong.httpclientutil.common.HttpHeader;
import com.arronlong.httpclientutil.common.HttpMethods;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;

import java.util.Objects;

public class HttpConfigBuilder {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.81 Safari/537.36 SE 2.X MetaSr 1.0";
    private static final int TIMEOUT = 5000;
    private static final int RETRY_TIMES = 5;

    public static HttpConfig build(RunResult runResult, JSONObject options) throws HttpProcessException {

        //请求地址
        String url = options.getString("url");
        String urlFromEvent = options.getString("url_from_event");
        String postUrl = options.getString("post_url");
        if (Objects.nonNull(urlFromEvent)) {
            url = urlFromEvent;
        }
        if (Objects.nonNull(postUrl)) {
            url = postUrl;
        }

        if (StringUtil.isEmpty(url)) {
            throw new IllegalOptionException("请求地址为空");
        }
        runResult.info("http请求地址：{}", url);
        //插件式配置Header（各种header信息、自定义header）
        HttpHeader httpHeader = HttpHeader.custom().userAgent(USER_AGENT);
        if (options.containsKey("headers")) {
            JSONObject headers = options.getJSONObject("headers");
            headers.forEach((key, value) -> httpHeader.other(key, value.toString()));
        }
        Header[] headers = httpHeader.build();
        //重试5次
        HCB hcb = HCB.custom().retry(RETRY_TIMES);
        //是否绕过ssl
        if (options.containsKey("disable_ssl_verification")) {
            if (options.getBoolean("disable_ssl_verification")) {
                if (StringUtil.isNotEmpty(options.getString("sslpv"))) {
                    hcb.sslpv(options.getString("sslpv"));
                }
                hcb.ssl();
            }
        }
        // 设置代理
        if (options.containsKey("proxy")) {
            String proxy = options.getString("proxy");
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
        if (options.containsKey("method")) {
            if (options.getString("method").equalsIgnoreCase(HttpMethods.POST.getName())) {
                buildPost(config, options);
            } else if (options.getString("method").equalsIgnoreCase(HttpMethods.GET.getName())) {
                config.method(HttpMethods.GET);
            }
        } else {
            // 默认post请求
            buildPost(config, options);
        }
        // 超时时间
        if (options.containsKey("timeout")) {
            config.timeout(options.getInteger("timeout"));
        }

        return config;
    }

    private static void buildPost(HttpConfig config, JSONObject options) {
        config.method(HttpMethods.POST);
        //设置请求体
        if (options.containsKey("data")) {
            if (options.containsKey("contentType")) {
                if (Objects.equals("application/json", options.getString("contentType"))) {
                    JSONObject data = options.getJSONObject("data");
                    config.json(data.toJSONString());
                } else {
                    JSONObject data = options.getJSONObject("data");
                    config.map(data);
                }
            } else {
                JSONObject data = options.getJSONObject("data");
                config.map(data);
            }
        }
    }
}
