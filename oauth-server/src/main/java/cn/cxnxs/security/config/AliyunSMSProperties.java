package cn.cxnxs.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p></p>
 *
 * @author mengjinyuan
 **/
@Data
@ConfigurationProperties(prefix = "aliyun.sms")
public class AliyunSMSProperties {

    private String accessKey;

    private String secretKey;

    private String regionId;

    private String product;

    private String domain;
}
