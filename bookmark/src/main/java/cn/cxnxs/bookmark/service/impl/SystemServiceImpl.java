package cn.cxnxs.bookmark.service.impl;

import cn.cxnxs.bookmark.entity.BmBookmark;
import cn.cxnxs.bookmark.entity.BmRecentVisited;
import cn.cxnxs.bookmark.service.SystemService;
import cn.cxnxs.common.api.auth.Oauth2Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-02-24 10:56
 **/
@Service
public class SystemServiceImpl implements SystemService {


    @Autowired
    private Oauth2Service oauth2Service;

    /**
     * 保存访问历史
     *
     * @param url 网址
     */
    @Override
    public void saveHistory(String url) {
        BmBookmark bmBookmark = new BmBookmark().selectOne(new LambdaQueryWrapper<BmBookmark>()
                .eq(BmBookmark::getUrl, url)
                .eq(BmBookmark::getUserId, oauth2Service.currentUser().getData().getInteger("id")));
        if (bmBookmark != null) {
            //先删后插
            BmRecentVisited bmRecentVisited = new BmRecentVisited().selectOne(new LambdaQueryWrapper<BmRecentVisited>()
                    .eq(BmRecentVisited::getBookmarkId, bmBookmark.getId())
                    .eq(BmRecentVisited::getUserId, oauth2Service.currentUser().getData().getInteger("id")));
            if (bmRecentVisited != null) {
                bmRecentVisited.setAccessCount(bmRecentVisited.getAccessCount() + 1);
                bmRecentVisited.setAccessTime(System.currentTimeMillis());
                bmRecentVisited.updateById();
            } else {
                bmRecentVisited = new BmRecentVisited();
                bmRecentVisited.setBookmarkId(bmBookmark.getId());
                bmRecentVisited.setUserId(oauth2Service.currentUser().getData().getInteger("id"));
                bmRecentVisited.setAccessCount(1);
                bmRecentVisited.setAccessTime(System.currentTimeMillis());
                bmRecentVisited.insert();
            }
        }

    }
}
