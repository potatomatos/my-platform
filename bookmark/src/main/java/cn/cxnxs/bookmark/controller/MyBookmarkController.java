package cn.cxnxs.bookmark.controller;

import cn.cxnxs.bookmark.service.MyBookmarkService;
import cn.cxnxs.bookmark.service.impl.MyBookmarkServiceImpl;
import cn.cxnxs.bookmark.vo.request.*;
import cn.cxnxs.bookmark.vo.response.BookmarkInfoVo;
import cn.cxnxs.bookmark.vo.response.CheckRespVo;
import cn.cxnxs.common.api.auth.Oauth2Service;
import cn.cxnxs.common.core.entity.TreeVo;
import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.exception.CommonException;
import cn.cxnxs.common.web.annotation.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * <p>我的书签页面前端控制器</p>
 *
 * @author mengjinyuan
 * @date 2022-02-17 16:29
 **/
@Slf4j
@RestController
@RequestMapping("my-bookmark")
public class MyBookmarkController {

    @Autowired
    private MyBookmarkService myBookmarkService;

    @Autowired
    private Oauth2Service oauth2Service;

    @PostMapping("/save/folder")
    public Result<Object> saveFolder(@RequestBody FolderVo folderVo) {
        return Result.success("保存成功", myBookmarkService.saveFolder(folderVo));
    }

    @PostMapping("/save/bookmark")
    public Result<Object> saveBookmark(@RequestBody BookmarkVo bookmarkVo) {
        return Result.success("保存成功", myBookmarkService.saveBookmark(bookmarkVo));
    }

    @ResponseResult
    @PostMapping("/foldersTree")
    public List<TreeVo> getFolderTree() {
        return myBookmarkService.getFolderTree(null);
    }

    @ResponseResult
    @PostMapping("/bookmarks/{pid}")
    public BookmarkInfoVo getBookmark(@PathVariable("pid") Integer pid,
                                      @RequestBody SearchVo searchVo) {
        return myBookmarkService.getBookmark(pid, searchVo);
    }

    @ResponseResult
    @PostMapping("/delete/folder/{id}")
    public Boolean deleteFolder(@PathVariable("id") Integer id) {
        return myBookmarkService.deleteFolder(id);
    }

    @ResponseResult
    @PostMapping("/delete/bookmark/{id}")
    public Boolean deleteBookmark(@PathVariable("id") Integer id) {
        return myBookmarkService.deleteBookmark(id);
    }

    @ResponseResult
    @PostMapping("/batchDelete")
    public Boolean batchDelete(@RequestBody List<BatchVo> batchVos) {
        return myBookmarkService.delete(batchVos);
    }

    @ResponseResult
    @PostMapping("/update/folder")
    public Boolean updateFolder(@RequestBody FolderVo folderVo) {
        return myBookmarkService.updateFolder(folderVo);
    }

    @ResponseResult
    @PostMapping("/update/bookmark")
    public Boolean updateBookmark(@RequestBody BookmarkVo bookmarkVo) {
        return myBookmarkService.updateBookmark(bookmarkVo);
    }

    @ResponseResult
    @PostMapping("/bookmark/favorites")
    public List<BookmarkVo> getFavoriteBookmark(@RequestBody SearchVo searchVo) {
        return myBookmarkService.getFavoriteBookmark(searchVo);
    }


    @ResponseResult
    @PostMapping("/import/bookmark")
    public Boolean importBookmark(@RequestParam("file") MultipartFile multipartFile,
                                  @RequestParam(value = "clearFlag", required = false) String clearFlag,
                                  @RequestParam(value = "newFolderFlag", required = false) String newFolderFlag) throws IOException {
        if (multipartFile!=null) {
            // 由于安全信息是线程绑定的，所以只能从这里先取出来再调异步接口了
            Result<JSONObject> currentUser = oauth2Service.currentUser();
            log.info("用户信息：{}",currentUser);
            if (currentUser == null || !currentUser.getCode().equals(Result.ResultEnum.SUCCESS.getCode())) {
                throw new CommonException("用户信息获取失败");
            }
            Integer userId = currentUser.getData().getInteger("id");
            myBookmarkService.importBookmark(userId,new String(multipartFile.getBytes(), StandardCharsets.UTF_8), clearFlag, newFolderFlag);
            return true;
        }else {
            return false;
        }
    }

    @ResponseResult
    @GetMapping("/import/progress")
    public JSONObject  getImportProgress () {
        return myBookmarkService.getImportProgress();
    }

    @ResponseResult
    @PostMapping("/bookmark/url/check")
    public CheckRespVo urlExist(String url) {
        return myBookmarkService.urlExist(url);
    }

    @ResponseResult
    @PostMapping("/recent")
    public List<BookmarkVo> recentVisited(@RequestBody PageWrapper pageWrapper) {
        return myBookmarkService.recentVisited(pageWrapper);
    }

    @ResponseResult
    @PostMapping("/check")
    public CheckVo checkInvalidUrl(@RequestBody BookmarkVo bookmarkVo) {
        return myBookmarkService.checkInvalidUrl(bookmarkVo.getFolderId());
    }

    @PostMapping("/cancelCheck")
    public Result<Object> cancelCheckInvalidUrl() {
        myBookmarkService.cancelCheckInvalidUrl();
        return Result.success();
    }

    @PostMapping("/move/{pid}")
    public Result<Boolean> move(@RequestBody List<BatchVo> moves, @PathVariable("pid") Integer pid) {
        myBookmarkService.moveBookmark(moves, pid);
        return Result.success();
    }


    @PostMapping("/test")
    public Result<Object> test() {
        myBookmarkService.cancelCheckInvalidUrl();
        //查出文件夹
        List<TreeVo> folderTree = myBookmarkService.getFolderTree(0);
        //计算收藏夹下收藏数
        Integer bookmarkCount = ((MyBookmarkServiceImpl) myBookmarkService).getBookmarkCount(folderTree);
        return Result.success(bookmarkCount);
    }

    @GetMapping("/redirect")
    public Result<String> redirect(Integer id,String url) {
        myBookmarkService.saveHistory(id);
        return Result.success("成功",url);
    }

}
