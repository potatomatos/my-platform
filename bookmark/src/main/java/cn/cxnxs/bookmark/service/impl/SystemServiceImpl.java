package cn.cxnxs.bookmark.service.impl;

import cn.cxnxs.bookmark.entity.BmBookmark;
import cn.cxnxs.bookmark.entity.BmRecentVisited;
import cn.cxnxs.bookmark.service.SystemService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-02-24 10:56
 **/
@Service
public class SystemServiceImpl implements SystemService {


    /**
     * 保存访问历史
     *
     * @param url 网址
     */
    @Override
    public void saveHistory(String url) {
        BmBookmark bmBookmark = new BmBookmark().selectOne(new LambdaQueryWrapper<BmBookmark>()
                .eq(BmBookmark::getUrl, url)
                .eq(BmBookmark::getUserId, null));
        if (bmBookmark != null) {
            //先删后插
            BmRecentVisited bmRecentVisited = new BmRecentVisited().selectOne(new LambdaQueryWrapper<BmRecentVisited>()
                    .eq(BmRecentVisited::getBookmarkId, bmBookmark.getId())
                    .eq(BmRecentVisited::getUserId, null));
            if (bmRecentVisited != null) {
                bmRecentVisited.setAccessCount(bmRecentVisited.getAccessCount() + 1);
                bmRecentVisited.setAccessTime(System.currentTimeMillis());
                bmRecentVisited.updateById();
            } else {
                bmRecentVisited = new BmRecentVisited();
                bmRecentVisited.setBookmarkId(bmBookmark.getId());
                bmRecentVisited.setUserId(null);
                bmRecentVisited.setAccessCount(1);
                bmRecentVisited.setAccessTime(System.currentTimeMillis());
                bmRecentVisited.insert();
            }
        }

    }
}
