package cn.cxnxs.security.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云短信配置
 */
@Configuration
@EnableConfigurationProperties(value = AliyunSMSProperties.class)
public class AliyunSMSConfig {

    @Autowired
    private AliyunSMSProperties aliyunSMSProperties;

    /**
     * 短信操作客户端
     *
     * @return
     * @throws ClientException
     */
    @Bean
    public IAcsClient acsClient() throws ClientException {
        IClientProfile profile = DefaultProfile.getProfile(aliyunSMSProperties.getRegionId(), aliyunSMSProperties.getAccessKey(), aliyunSMSProperties.getSecretKey());
        DefaultProfile.addEndpoint(aliyunSMSProperties.getRegionId(), aliyunSMSProperties.getRegionId(), aliyunSMSProperties.getProduct(), aliyunSMSProperties.getDomain());
        return new DefaultAcsClient(profile);
    }
}
