package cn.cxnxs.scheduler.core.agents;


import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.core.SingleSourceAgent;
import cn.cxnxs.scheduler.core.agents.http.HttpConfigBuilder;
import com.alibaba.fastjson.JSON;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * <p>网站代理</p>
 *
 * @author mengjinyuan
 * @date 2021-01-18 14:02
 **/
@Component
@Scope("prototype")
@Slf4j
public class PostAgent extends SingleSourceAgent {

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
        runResult.log("数据post完成！用时：{}ms,返回结果结果：{}", System.currentTimeMillis() - start, JSON.toJSONString(respResult));
    }
}
