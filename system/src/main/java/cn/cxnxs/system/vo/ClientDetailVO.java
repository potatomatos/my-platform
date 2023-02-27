package cn.cxnxs.system.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientDetailVO extends AppVO {

    @NotEmpty(message = "clientId不能为空")
    private String clientId;

    private String resourceIds;

    @NotEmpty(message = "密码不能为空")
    private String clientSecret;

    private String scope;

    @NotEmpty(message = "授权类型不能为空")
    private String authorizedGrantTypes;

    @NotEmpty(message = "回调地址不能为空")
    private String webServerRedirectUri;

    private String authorities;

    @NotNull(message = "超时时间不能为空")
    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalInformation;

    @NotEmpty
    private String autoapprove;
}
