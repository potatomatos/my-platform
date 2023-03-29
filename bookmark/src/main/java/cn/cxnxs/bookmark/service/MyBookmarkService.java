package cn.cxnxs.bookmark.service;

import cn.cxnxs.bookmark.vo.request.*;
import cn.cxnxs.bookmark.vo.response.BookmarkInfoVo;
import cn.cxnxs.bookmark.vo.response.CheckRespVo;
import cn.cxnxs.common.core.entity.TreeVo;
import cn.cxnxs.common.core.entity.request.PageWrapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 我的书签
 * @author potatomato
 */
public interface MyBookmarkService {

    /**
     * 保存文件夹
     * @param folderVo 入参
     * @return
     */
    Integer saveFolder(FolderVo folderVo);

    /**
     * 保存书签
     * @param bookmarkVo
     */
    Integer saveBookmark(BookmarkVo bookmarkVo);

    /**
     * 获得书签树
     * @return
     */
    List<TreeVo> getFolderTree(Integer root);

    List<TreeVo> getAllFolder();

    List<TreeVo> getAllParents(Integer pid);

    List<TreeVo> getBookmarkTree();

    BookmarkInfoVo getBookmark(Integer pid, SearchVo searchVo);

    @Transactional(rollbackFor = RuntimeException.class)
    Boolean delete(List<BatchVo> batchVos);

    /**
     * 删除文件夹
     *
     * @param id
     */
    Boolean deleteFolder(Integer id);

    /**
     * 删除书签
     * @param id
     * @return
     */
    Boolean deleteBookmark(Integer id);

    Boolean deleteBookmarkBatch(List<Integer> bookmarkIds);

    /**
     * 更新文件夹
     *
     * @param folderVo
     * @return
     */
    Boolean updateFolder(FolderVo folderVo);
    /**
     * 更新书签
     *
     * @param bookmarkVo
     * @return
     */
    Boolean updateBookmark(BookmarkVo bookmarkVo);
    /**
     * 获取特别收藏列表
     *
     * @param searchVo
     * @return
     */
    List<BookmarkVo> getFavoriteBookmark(SearchVo searchVo);


    /**
     * 判断url是否存在
     * @param url 网址
     * @return true-已存在 false-不存在
     */
    CheckRespVo urlExist(String url);

    List<BookmarkVo> recentVisited(PageWrapper pageWrapper);

    CheckVo checkInvalidUrl(Integer folderId);

    void cancelCheckInvalidUrl();

    Boolean moveBookmark(List<BatchVo> moves, Integer pid);

    void saveHistory(Integer id);
    /**
     * 导入书签
     *
     * @param request
     * @param multipartFile
     * @param clearFlag
     * @param newFolderFlag
     * @throws IOException
     */
    void importBookmark(HttpServletRequest request, MultipartFile multipartFile, String clearFlag, String newFolderFlag) throws IOException;
}
