package cn.cxnxs.bookmark.mapper;

import cn.cxnxs.bookmark.entity.BmBookmark;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 书签 Mapper 接口
 * </p>
 *
 * @author mengjinyuan
 * @since 2022-02-17
 */
public interface BmBookmarkMapper extends BaseMapper<BmBookmark> {

    /**
     * 查询最近访问
     * @param userId 用户编号
     * @return
     */
    @Select("SELECT b.id,b.title,b.url,b.icon_url,b.state,b.folder_id,b.user_id,b.favorite_flg,a.access_time create_time from bm_recent_visited a LEFT JOIN bm_bookmark b on a.bookmark_id=b.id WHERE b.user_id=#{userId} ORDER BY a.access_time DESC")
    List<BmBookmark> getRecentVisited(Integer userId);

    @Select("select IFNULL( max(sort_no)+1,1) as maxSort from bm_bookmark  where folder_id = #{pid} for update")
    Integer getNewSortNo(Integer pid);
}
