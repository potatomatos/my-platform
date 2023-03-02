package cn.cxnxs.bookmark.vo.response;

import cn.cxnxs.common.core.entity.TreeVo;
import lombok.Data;

import java.util.List;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2023-03-02 22:42
 **/
@Data
public class BookmarkInfoVo {

    private List<TreeVo> bookmarks;
    private List<TreeVo> parents;
}
