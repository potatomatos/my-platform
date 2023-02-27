package cn.cxnxs.telegram.config;

import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.IOError;
import java.io.IOException;

/**
 * <p>客户端配置类</p>
 *
 * @author mengjinyuan
 * @date 2021-09-26 23:55
 **/
@Configuration
public class TdClientConfig implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(cn.cxnxs.telegram.config.client.TdClientConfig.class);

    @Autowired
    private cn.cxnxs.telegram.config.client.TgConfig tgConfig;

    @Override
    public void run(String... args) throws Exception {
        //加载库
        System.load(tgConfig.getTdlib());
        logger.info("======cn.cxnxs.telegram.tdlib loaded======");
        //关闭日志
        Boolean disableLog = tgConfig.getDisableLog();
        if (disableLog != null && disableLog) {
            Client.execute(new TdApi.SetLogVerbosityLevel(0));
            if (Client.execute(new TdApi.SetLogStream(new TdApi.LogStreamFile("cn.cxnxs.telegram.tdlib.log", 1 << 27, false))) instanceof TdApi.Error) {
                throw new IOError(new IOException("Write access to the current directory is required"));
            }
        }
    }
}
