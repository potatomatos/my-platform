package cn.cxnxs.bookmark.mapper;

import cn.cxnxs.bookmark.entity.BmFolder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 文件夹 Mapper 接口
 * </p>
 *
 * @author mengjinyuan
 * @since 2022-02-17
 */
public interface BmFolderMapper extends BaseMapper<BmFolder> {

    @Select("select IFNULL( max(sort_no)+1,1) as maxSort from bm_folder  where parent_id = #{pid} and user_id = #{userId} for update")
    Integer getNewSortNo(@Param("userId") Integer userId, @Param("pid") Integer pid);
}
