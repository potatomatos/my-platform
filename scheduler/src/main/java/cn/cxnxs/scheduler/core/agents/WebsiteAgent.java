package cn.cxnxs.scheduler.core.agents;


import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.core.SingleSourceAgent;
import cn.cxnxs.scheduler.core.agents.http.ContentType;
import cn.cxnxs.scheduler.core.agents.http.HttpConfigBuilder;
import cn.cxnxs.scheduler.core.agents.parser.WebSiteContentParser;
import cn.cxnxs.scheduler.core.agents.parser.WebSiteParserFactory;
import com.alibaba.fastjson.JSONArray;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
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
public class WebsiteAgent extends SingleSourceAgent {

    @Override
    public void start(RunResult runResult) throws Exception {
        long start = System.currentTimeMillis();
        HttpConfig config = HttpConfigBuilder.build(runResult, this.getOptions());
        runResult.info("-----------请求参数-----------");
        runResult.info("配置信息：{}", this.getOptions().toJSONString());
        runResult.info("-----------------------------");
        HttpResult respResult = HttpClientUtil.sendAndGetResp(config);
        runResult.info("返回状态：{}", respResult.getStatusLine());
        if (respResult.getStatusCode() != HttpStatus.SC_OK) {
            return;
        }
        //处理返回结果
        WebSiteContentParser webSiteContentParser = WebSiteParserFactory.getParser(ContentType.valueOf(this.getOptions().getString("type").toUpperCase(Locale.ENGLISH)));
        JSONArray maps = webSiteContentParser.parse(this.getOptions().getJSONObject("extract"), respResult.getResult(), runResult);
        runResult.log("解析完成！用时：{}ms,数据大小：{}，最终解析结果：\n{}", System.currentTimeMillis() - start, maps.size(), maps.toJSONString());
        runResult.setPayload(maps);
    }
}
