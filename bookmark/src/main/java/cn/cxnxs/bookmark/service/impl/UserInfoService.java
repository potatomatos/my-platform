package cn.cxnxs.bookmark.service.impl;

import cn.cxnxs.common.api.auth.Oauth2Service;
import cn.cxnxs.common.cache.RedisUtils;
import cn.cxnxs.common.core.entity.UserInfo;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.exception.CommonException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserInfoService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private Oauth2Service oauth2Service;

    public UserInfo currentUser() {
        String accessToken = request.getHeader("access_token");
        UserInfo userInfo = null;
        if (accessToken!=null) {
            if (redisUtils.hasKey(accessToken)){
                userInfo = redisUtils.get(accessToken);
            } else {
                Result<JSONObject> result = oauth2Service.currentUser();
                if (result.ok()) {
                    JSONObject data = result.getData();
                    userInfo = JSONObject.parseObject(data.toJSONString(), UserInfo.class);
                    redisUtils.set(accessToken,userInfo,7200*60);
                }
            }
        }
        if (userInfo == null) {
            throw new CommonException("用户信息获取失败");
        }
        return userInfo;
    }

}
