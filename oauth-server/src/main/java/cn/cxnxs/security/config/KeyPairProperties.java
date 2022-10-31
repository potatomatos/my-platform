package cn.cxnxs.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-10-30 22:48
 **/
@Data
@ConfigurationProperties(prefix = "key-pair")
public class KeyPairProperties {

    private String keyFile;

    private String storePassword;

    private String alias;

    private String password;
}
