package cn.cxnxs.minio.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    private String url;
    private String accessKey;
    private String secretKey;
    private String bucketName;

}
