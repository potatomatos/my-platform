package cn.cxnxs.security.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GithubAccessToken {

    @JsonProperty("access_token")
    private String accessToken;
}
