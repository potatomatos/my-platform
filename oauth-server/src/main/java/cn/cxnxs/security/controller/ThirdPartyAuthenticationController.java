package cn.cxnxs.security.controller;

import cn.cxnxs.security.config.GithubOauthProperties;
import cn.cxnxs.security.entity.GithubAccessToken;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ThirdPartyAuthenticationController {

    @Autowired
    private GithubOauthProperties githubOauthProperties;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("github/callback")
    public String githubCallback(String code) {
        // 获取Token的Url
        String tokenUrl = "https://github.com/login/oauth/access_token" +
                "?client_id=" + githubOauthProperties.getClientId() +
                "&client_secret=" + githubOauthProperties.getClientSecret() +
                "&code=" + code;
        GithubAccessToken githubAccessToken = restTemplate.postForObject(tokenUrl, null, GithubAccessToken.class);
        assert githubAccessToken != null;
        String accessToken = githubAccessToken.getAccessToken();
        // 获取用户信息
        String apiUrl = "https://api.github.com/user";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<JSONObject> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, JSONObject.class);
        //TODO 判断用户是否注册
        return "";
    }
}
