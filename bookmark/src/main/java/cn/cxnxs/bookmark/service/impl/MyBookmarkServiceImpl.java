package cn.cxnxs.bookmark.service.impl;

import cn.cxnxs.bookmark.entity.BmBookmark;
import cn.cxnxs.bookmark.entity.BmFolder;
import cn.cxnxs.bookmark.entity.BmRecentVisited;
import cn.cxnxs.bookmark.mapper.BmBookmarkMapper;
import cn.cxnxs.bookmark.mapper.BmFolderMapper;
import cn.cxnxs.bookmark.service.MyBookmarkService;
import cn.cxnxs.bookmark.vo.request.*;
import cn.cxnxs.bookmark.vo.response.BookmarkInfoVo;
import cn.cxnxs.bookmark.vo.response.CheckRespVo;
import cn.cxnxs.bookmark.vo.response.WebsocketVo;
import cn.cxnxs.bookmark.websocket.WebSocketServer;
import cn.cxnxs.common.api.auth.Oauth2Service;
import cn.cxnxs.common.cache.RedisUtils;
import cn.cxnxs.common.core.entity.TreeVo;
import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.exception.CommonException;
import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.common.core.utils.TreeUtil;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.*;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-02-18 11:14
 **/
@Service
public class MyBookmarkServiceImpl implements MyBookmarkService {

    @Resource
    private BmBookmarkMapper bmBookmarkMapper;
    @Resource
    private BmFolderMapper bmFolderMapper;

    @Autowired
    private Oauth2Service oauth2Service;

    @Autowired
    private RedisUtils redisUtils;

    private static final int ROOT_ID = 0;

    private static final String REDIS_KEY = "checkInvalidUrl:";

    /**
     * 存放文件上传处理进度
     */
    public static final String PROGRESS_KEY = "IMPORT_PROGRESS_";

    private static final Logger logger = LoggerFactory.getLogger(MyBookmarkServiceImpl.class);

    @Autowired
    private HttpServletRequest request;

    @Override
    public Integer saveFolder(FolderVo folderVo) {
        Integer count = new BmFolder().selectCount(new LambdaQueryWrapper<BmFolder>().eq(BmFolder::getFolderName, folderVo.getFolderName()));
        if (count == 0) {
            //对象转换
            BmFolder bmFolder = new BmFolder();
            ObjectUtil.transValues(folderVo, bmFolder);
            if (bmFolder.getParentId() == null) {
                bmFolder.setParentId(ROOT_ID);
            }
            if (bmFolder.getCreateTime()==null){
                bmFolder.setCreateTime(System.currentTimeMillis());
            }
            //计算序号
            bmFolder.setSortNo(new BmFolder().selectCount(new LambdaQueryWrapper<BmFolder>().eq(BmFolder::getParentId, folderVo.getParentId())) + 1);
            bmFolder.setUserId(oauth2Service.currentUser().getData().getInteger("id"));
            bmFolder.insert();
            return bmFolder.getId();
        } else {
            throw new CommonException("收藏夹名称已存在");
        }

    }

    @Override
    public Integer saveBookmark(BookmarkVo bookmarkVo) {
        if (this.urlExist(bookmarkVo.getUrl()).getExist()) {
            throw new CommonException("url已存在！");
        }
        //对象转换
        BmBookmark bmBookmark = new BmBookmark();
        ObjectUtil.transValues(bookmarkVo, bmBookmark);
        if (bmBookmark.getFolderId() == null) {
            bmBookmark.setFolderId(ROOT_ID);
        }
        if (bookmarkVo.getCreateTime()==null){
            bmBookmark.setCreateTime(System.currentTimeMillis());
        }
        bmBookmark.setUserId(oauth2Service.currentUser().getData().getInteger("id"));
        bmBookmark.setFavoriteFlg(0);
        bmBookmark.setAccessCount(0);
        bmBookmark.setSortNo(new BmBookmark().selectCount(new LambdaQueryWrapper<BmBookmark>().eq(BmBookmark::getFolderId, bmBookmark.getFolderId())) + 1);
        if (StringUtil.isEmpty(bmBookmark.getIconUrl())) {
            bmBookmark.setIconUrl(this.getWebsiteIcon(bmBookmark.getUrl()));
        }
        bmBookmark.insert();
        return bmBookmark.getId();
    }

    /**
     * 获得书签树
     *
     * @return 树状数据结构
     */
    @Override
    public List<TreeVo> getFolderTree(Integer root) {

        if (root == null) {
            root = ROOT_ID;
        }
        return TreeUtil.toTreeVo(getAllFolder(), root);
    }

    @Override
    public List<TreeVo> getAllFolder() {
        //查出所有的文件夹
        LambdaQueryWrapper<BmFolder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BmFolder::getUserId, oauth2Service.currentUser().getData().getInteger("id"));
        queryWrapper.orderByAsc(BmFolder::getSortNo);
        List<BmFolder> bmFolders = new BmFolder().selectList(queryWrapper);
        List<TreeVo> treeVos = new ArrayList<>();
        bmFolders.forEach(bmFolder -> {
            TreeVo treeVo = new TreeVo();
            treeVo.setNodeId(bmFolder.getId());
            treeVo.setParentNodeId(bmFolder.getParentId());
            treeVo.setTitle(bmFolder.getFolderName());
            treeVos.add(treeVo);
        });
        return treeVos;
    }

    /**
     * 获得所有上级（包括自己）
     * @param pid
     * @return
     */
    @Override
    public List<TreeVo> getAllParents(Integer pid){
        List<TreeVo> allFolder = this.getAllFolder();
        List<TreeVo> parents = new ArrayList<>();
        this.parents(allFolder,parents,pid);
        return parents;
    }

    private void parents(List<TreeVo> allFolder,List<TreeVo> parents,Object id) {
        for (TreeVo treeVo : allFolder) {
            if (treeVo.getNodeId().equals(id)){
                parents.add(treeVo);
                this.parents(allFolder,parents,treeVo.getParentNodeId());
            }
        }
    }

    @Override
    public BookmarkInfoVo getBookmark(Integer pid, SearchVo searchVo) {
        if (pid == null) {
            pid = ROOT_ID;
        }
        List<TreeVo> treeVos = new ArrayList<>();
        //查出书签
        LambdaQueryWrapper<BmBookmark> bookmarkLambdaQueryWrapper = new LambdaQueryWrapper<>();
        bookmarkLambdaQueryWrapper.eq(BmBookmark::getUserId, oauth2Service.currentUser().getData().getInteger("id"));
        if (searchVo.getSort() != null) {
            if (SearchVo.SORT_TITLE.equals(searchVo.getSort())) {
                bookmarkLambdaQueryWrapper.orderByAsc(BmBookmark::getTitle, BmBookmark::getSortNo);
            } else if (SearchVo.SORT_DOMAIN.equals(searchVo.getSort())) {
                bookmarkLambdaQueryWrapper.orderByAsc(BmBookmark::getUrl, BmBookmark::getSortNo);
            } else if(SearchVo.SORT_LATEST.equals(searchVo.getSort())){
                bookmarkLambdaQueryWrapper.orderByDesc(BmBookmark::getAccessCount);
            }else {
                bookmarkLambdaQueryWrapper.orderByAsc(BmBookmark::getTitle, BmBookmark::getSortNo);
            }
        } else {
            bookmarkLambdaQueryWrapper.orderByAsc(BmBookmark::getSortNo);
        }
        if (StringUtil.isNotEmpty(searchVo.getKeyword())) {
            bookmarkLambdaQueryWrapper.like(BmBookmark::getTitle, searchVo.getKeyword())
                    .or()
                    .like(BmBookmark::getUrl, searchVo.getKeyword());
        } else {
            bookmarkLambdaQueryWrapper.eq(BmBookmark::getFolderId, pid);
            //计算收藏夹下收藏数
            LambdaQueryWrapper<BmFolder> folderLambdaQueryWrapper = new LambdaQueryWrapper<>();
            folderLambdaQueryWrapper.eq(BmFolder::getParentId, pid);
            folderLambdaQueryWrapper.eq(BmFolder::getUserId, oauth2Service.currentUser().getData().getInteger("id"));
            folderLambdaQueryWrapper.orderByAsc(BmFolder::getSortNo);
            List<BmFolder> bmFolders = new BmFolder().selectList(folderLambdaQueryWrapper);
            bmFolders.forEach(bmFolder -> {
                TreeVo treeVo = new TreeVo();
                treeVo.setNodeId(bmFolder.getId());
                treeVo.setParentNodeId(bmFolder.getParentId());
                treeVo.setTitle(bmFolder.getFolderName());
                treeVo.setType(1);
                treeVo.setSort(bmFolder.getSortNo());
                treeVo.setCreateTime(bmFolder.getCreateTime());
                treeVos.add(treeVo);
            });
        }
        List<BmBookmark> bmBookmarks = new BmBookmark().selectList(bookmarkLambdaQueryWrapper);
        bmBookmarks.forEach(bmBookmark -> {
            TreeVo treeVo = new TreeVo();
            treeVo.setNodeId(bmBookmark.getId());
            treeVo.setParentNodeId(bmBookmark.getFolderId());
            treeVo.setTitle(bmBookmark.getTitle());
            treeVo.setHref(bmBookmark.getUrl());
            treeVo.setIcon(bmBookmark.getIconUrl());
            treeVo.setType(2);
            treeVo.setSort(bmBookmark.getSortNo());
            treeVo.setCreateTime(bmBookmark.getCreateTime());
            JSONObject json = new JSONObject();
            json.put("favoriteFlg", bmBookmark.getFavoriteFlg());
            json.put("state", bmBookmark.getState());
            treeVo.setExpandData(json);
            treeVos.add(treeVo);
        });
        List<TreeVo> parents = this.getAllParents(pid);
        BookmarkInfoVo bookmarkInfoVo = new BookmarkInfoVo();
        bookmarkInfoVo.setBookmarks(treeVos);
        Collections.reverse(parents);
        bookmarkInfoVo.setParents(parents);
        TreeVo cwd = new TreeVo();
        if (ROOT_ID == pid) {
            cwd.setNodeId(0);
            cwd.setTitle("我的收藏");
        } else {
            BmFolder parent = new BmFolder().selectById(pid);
            if (parent!=null) {
                cwd.setNodeId(parent.getId());
                cwd.setParentNodeId(parent.getParentId());
                cwd.setTitle(parent.getFolderName());
            }
        }
        bookmarkInfoVo.setCwd(cwd);
        return bookmarkInfoVo;
    }

    /**
     * 递归获取书签数量
     *
     * @param folderTree 文件树
     * @return
     */
    public Integer getBookmarkCount(List<TreeVo> folderTree) {
        Integer count = 0;
        for (TreeVo treeVo : folderTree) {
            count += new BmBookmark().selectCount(new LambdaQueryWrapper<BmBookmark>()
                    .eq(BmBookmark::getFolderId, treeVo.getNodeId()));
            if (treeVo.getChildren() != null && !treeVo.getChildren().isEmpty()) {
                count += getBookmarkCount(treeVo.getChildren());
            }
        }
        return count;
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Boolean delete(List<BatchVo> batchVos){
        // 筛选出文件夹和书签
        List<BatchVo> folders = batchVos.stream().filter(item -> item.getType().equals(1)).collect(Collectors.toList());
        List<BatchVo> bookmarks = batchVos.stream().filter(item -> item.getType().equals(2)).collect(Collectors.toList());
        this.deleteBookmarkBatch(bookmarks.stream().map(BatchVo::getId).collect(Collectors.toList()));
        for (BatchVo folder : folders) {
            this.deleteFolder(folder.getId());
        }
        return Boolean.TRUE;
    }

    /**
     * 删除文件夹
     *
     * @param id
     */
    @Override
    public Boolean deleteFolder(Integer id) {
        List<TreeVo> folderTree = getFolderTree(id);
        //删除本级
        BmFolder bmFolder = new BmFolder();
        bmFolder.setId(id);
        bmFolder.setUserId(oauth2Service.currentUser().getData().getInteger("id"));
        bmFolder.deleteById();
        new BmBookmark().delete(new LambdaQueryWrapper<BmBookmark>()
                .eq(BmBookmark::getFolderId, id)
                .eq(BmBookmark::getUserId, oauth2Service.currentUser().getData().getInteger("id")));
        //递归删除下级
        deleteFolderRecursion(folderTree);
        return false;
    }

    /**
     * 递归删除
     *
     * @param folderTree
     * @return
     */
    public void deleteFolderRecursion(List<TreeVo> folderTree) {
        for (TreeVo treeVo : folderTree) {
            BmFolder bmFolder = new BmFolder();
            bmFolder.setId((int)treeVo.getNodeId());
            bmFolder.setUserId(oauth2Service.currentUser().getData().getInteger("id"));
            bmFolder.deleteById();
            new BmBookmark().delete(new LambdaQueryWrapper<BmBookmark>()
                    .eq(BmBookmark::getFolderId, treeVo.getNodeId())
                    .eq(BmBookmark::getUserId, oauth2Service.currentUser().getData().getInteger("id")));
            if (treeVo.getChildren() != null && !treeVo.getChildren().isEmpty()) {
                deleteFolderRecursion(treeVo.getChildren());
            }
        }
    }

    /**
     * 删除书签
     *
     * @param id
     * @return
     */
    @Override
    public Boolean deleteBookmark(Integer id) {
        BmBookmark bmBookmark = new BmBookmark();
        bmBookmark.setId(id);
        bmBookmark.setUserId(oauth2Service.currentUser().getData().getInteger("id"));
        return bmBookmark.deleteById();
    }

    /**
     * 批量删除收藏
     *
     * @param bookmarkIds id列表
     * @return
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Boolean deleteBookmarkBatch(List<Integer> bookmarkIds) {
        for (Integer bookmarkId : bookmarkIds) {
            this.deleteBookmark(bookmarkId);
        }
        return Boolean.TRUE;
    }


    /**
     * 更新文件夹
     *
     * @param folderVo
     * @return
     */
    @Override
    public Boolean updateFolder(FolderVo folderVo) {
        if (folderVo.getId() == null) {
            throw new CommonException(Result.ResultEnum.BAD_REQUEST.getInfo());
        }
        BmFolder bmFolder = new BmFolder().selectOne(new LambdaQueryWrapper<BmFolder>()
                .eq(BmFolder::getId, folderVo.getId())
                .eq(BmFolder::getUserId, oauth2Service.currentUser().getData().getInteger("id")));
        if (bmFolder == null) {
            return false;
        }
        ObjectUtil.transValues(folderVo, bmFolder);
        bmFolder.setUpdateTime(System.currentTimeMillis());
        return bmFolder.updateById();
    }

    /**
     * 更新书签
     *
     * @param bookmarkVo
     * @return
     */
    @Override
    public Boolean updateBookmark(BookmarkVo bookmarkVo) {
        if (bookmarkVo.getId() == null) {
            throw new CommonException(Result.ResultEnum.BAD_REQUEST.getInfo());
        }

        BmBookmark bmBookmark = new BmBookmark().selectOne(new LambdaQueryWrapper<BmBookmark>()
                .eq(BmBookmark::getId, bookmarkVo.getId())
                .eq(BmBookmark::getUserId, oauth2Service.currentUser().getData().getInteger("id")));
        if (bmBookmark == null) {
            return false;
        }
        ObjectUtil.transValues(bookmarkVo, bmBookmark);
        bmBookmark.setUpdateTime(System.currentTimeMillis());
        bmBookmark.setIconUrl(getWebsiteIcon(bmBookmark.getUrl()));
        return bmBookmark.updateById();
    }

    /**
     * 获取特别收藏列表
     *
     * @param searchVo
     * @return
     */
    @Override
    public List<BookmarkVo> getFavoriteBookmark(SearchVo searchVo) {
        LambdaQueryWrapper<BmBookmark> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtil.isNotEmpty(searchVo.getKeyword())) {
            queryWrapper.like(BmBookmark::getTitle, searchVo.getKeyword())
                    .or()
                    .like(BmBookmark::getUrl, searchVo.getKeyword());
        }
        queryWrapper.eq(BmBookmark::getFavoriteFlg, 1);
        queryWrapper.eq(BmBookmark::getUserId, oauth2Service.currentUser().getData().getInteger("id"));
        queryWrapper.orderByAsc(BmBookmark::getSortNo);
        List<BmBookmark> bmBookmarks = new BmBookmark().selectList(queryWrapper);
        //对象转换
        return ObjectUtil.copyListProperties(bmBookmarks, BookmarkVo.class);
    }

    /**
     * 获取网站图标
     *
     * @return 图标地址
     */
    private String getWebsiteIcon(String navUrl) {
        String iconUrl = "";
        try {
            HttpResult respResult = this.httpGet(navUrl, 2);
            Document doc = Jsoup.parse(respResult.getResult());
            //提取图标
            Elements elements = doc.select("head>link[type=\"image/x-icon\"]");
            if (elements == null || elements.isEmpty()) {
                elements = doc.select("head>link[rel=\"shortcut icon\"]");
            }

            if (elements != null && !elements.isEmpty()) {
                iconUrl = elements.get(0).attr("href");
                //判断是否是相对路径，如果是则拼接域名
                if (iconUrl.indexOf("//") == 0) {
                    URL url = new URL(navUrl);
                    iconUrl = url.getProtocol() + ":" + iconUrl;
                } else if (iconUrl.indexOf("/") == 0) {
                    //如果没有找到则直接拼接
                    URL url = new URL(navUrl);
                    String domain = url.getProtocol() + "://" + url.getHost();
                    if (url.getPort() != -1) {
                        iconUrl = domain + ":" + url.getPort() + iconUrl;
                    } else {
                        iconUrl = domain + iconUrl;
                    }
                }
            } else {
                //如果没有找到则直接拼接
                iconUrl = getDefaultIcon(navUrl);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            try {
                iconUrl = getDefaultIcon(navUrl);
            } catch (Exception e1) {
                logger.error(e.getMessage(), e);
            }

        }
        return iconUrl;
    }

    /**
     * 发送http请求
     *
     * @param navUrl 网址
     * @return
     * @throws HttpProcessException
     */
    private HttpResult httpGet(String navUrl, Integer retry) throws HttpProcessException, UnsupportedEncodingException {
        //插件式配置Header（各种header信息、自定义header）
        HttpHeader httpHeader = HttpHeader.custom().userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.81 Safari/537.36 SE 2.X MetaSr 1.0");
        Header[] headers = httpHeader.build();
        if (retry == null) {
            retry = 1;
        }
        //重试
        HCB hcb = HCB.custom().retry(retry);
        //是否绕过ssl
        try {
            hcb.ssl();
        } catch (HttpProcessException e) {
            logger.error(e.getMessage(), e);
        }
        HttpClient client = hcb.build();
        //获取返回的cookie
        HttpCookies cookies = HttpCookies.custom();
        //插件式配置请求参数（网址、请求参数、编码、client）
        HttpConfig config = HttpConfig.custom()
                .url(navUrl)
                .headers(headers)
                .client(client)
                .encoding("utf-8")
                .timeout(5000)
                .context(cookies.getContext())
                .method(HttpMethods.GET);
        logger.info("url:{}", navUrl);
        HttpResult respResult = HttpClientUtil.sendAndGetResp(config);
        logger.info("-----------------------------");
        logger.info("statusLine：{}", respResult.getStatusLine());
        logger.info("statusCode：{}", respResult.getStatusCode());
        logger.info("-----------------------------");
        return respResult;
    }

    private String getDefaultIcon(String navUrl) throws MalformedURLException {
        //如果没有找到则直接拼接
        URL url = new URL(navUrl);
        String iconUrl = url.getProtocol() + "://" + url.getHost();
        if (url.getPort() != -1) {
            iconUrl = iconUrl + ":" + url.getPort() + "/favicon.ico";
        } else {
            iconUrl = iconUrl + "/favicon.ico";
        }
        return iconUrl;
    }

    /**
     * @param content
     * @param clearFlag
     * @param newFolderFlag
     */
    @Async
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void importBookmark(Integer userId,String content, String clearFlag, String newFolderFlag) {
        Document doc = Jsoup.parse(content);
        if (StringUtil.isNotEmpty(clearFlag)&& "1".equals(clearFlag)) {
            //删除所有数据
            new BmFolder().delete(new LambdaQueryWrapper<BmFolder>().eq(BmFolder::getUserId, userId));
            new BmBookmark().delete(new LambdaQueryWrapper<BmBookmark>().eq(BmBookmark::getUserId, userId));
            new BmRecentVisited().delete(new LambdaQueryWrapper<BmRecentVisited>().eq(BmRecentVisited::getUserId, userId));
        }
        Integer pid = null;
        if (StringUtil.isNotEmpty(newFolderFlag)&& "1".equals(newFolderFlag)) {
            //新建收藏夹
            FolderVo folderVo = new FolderVo();
            folderVo.setFolderName("新导入收藏夹" + System.currentTimeMillis());
            pid = this.saveFolder(folderVo);
        }

        //提取第一次层
        Element element = doc.select("dl").first();
        List<BookmarkVo> bookmarkVos = new ArrayList<>();
        parseHtml(element, userId,pid, bookmarkVos);
        int total = bookmarkVos.size();
        if (total == 0) {
            throw new CommonException();
        }
        for (int i = 0; i < total; i++) {
            this.saveBookmark(bookmarkVos.get(i));
            //通知前端进度
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("total", total);
            jsonObject.put("index", (i + 1));
            jsonObject.put("title", bookmarkVos.get(i).getTitle());
            redisUtils.set(PROGRESS_KEY+userId,jsonObject,24*3600);
        }
        redisUtils.del(PROGRESS_KEY+userId);
    }

    private void parseHtml(Element element, Integer userId, Integer pid, List<BookmarkVo> bmBookmarks) {
        Elements children = element.children();
        int size = children.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                Element el = children.get(i);
                Element dl = el.select("dl").first();
                if (dl != null) {
                    //文件夹类型，继续递归解析
                    String folderName = el.select("h3").first().text();
                    String addDate=el.select("h3").first().attr("add_date");
                    logger.info("======folderName：{}，addDate:{}=======", folderName,addDate);
                    FolderVo folderVo = new FolderVo();
                    folderVo.setFolderName(folderName);
                    folderVo.setParentId(pid);
                    folderVo.setUserId(userId);
                    folderVo.setCreateTime(Long.parseLong(addDate));
                    Integer id = this.saveFolder(folderVo);
                    parseHtml(dl, userId, id, bmBookmarks);
                } else {
                    Element a = el.select("a").first();
                    if (a != null) {
                        String title=a.text();
                        String url=a.attr("href");
                        String addDate=a.attr("add_date");
                        logger.info("title:{},addDate:{},url:{}", title, addDate,url);
                        BookmarkVo bookmarkVo = new BookmarkVo();
                        bookmarkVo.setFolderId(pid);
                        bookmarkVo.setUrl(url);
                        bookmarkVo.setTitle(title);
                        bookmarkVo.setUserId(userId);
                        bookmarkVo.setCreateTime(Long.parseLong(addDate));
                        bmBookmarks.add(bookmarkVo);
                    }
                }
            }
        }
    }

    /**
     * 获取文件导入进度条
     * @return
     */
    @Override
    public JSONObject  getImportProgress() {
        JSONObject currentUser = oauth2Service.currentUser().getData();
        if (currentUser == null) {
            throw new CommonException("用户信息获取失败");
        }
        Integer userId = currentUser.getInteger("id");
        if (redisUtils.hasKey(PROGRESS_KEY+userId)) {
            return redisUtils.get(PROGRESS_KEY+userId);
        } else {
            return new JSONObject();
        }
    }
    /**
     * 判断url是否存在
     *
     * @param url 网址
     * @return true-已存在 false-不存在
     */
    @Override
    public CheckRespVo urlExist(String url) {
        if (StringUtil.isEmpty(url)) {
            throw new CommonException("url不能为空");
        }
        BmBookmark bmBookmark = new BmBookmark();
        List<BmBookmark> list = bmBookmark.selectList(new LambdaQueryWrapper<BmBookmark>()
                .eq(BmBookmark::getUserId, oauth2Service.currentUser().getData().getInteger("id"))
                .eq(BmBookmark::getUrl, url));
        CheckRespVo checkRespVo=new CheckRespVo();
        checkRespVo.setExist(list.size() > 0);
        if (checkRespVo.getExist()){
            //获取url所在收藏夹路径
            List<TreeVo> allFolder = getAllFolder();
            Integer folderId = list.get(0).getFolderId();
            List<Object> parentIds = TreeUtil.queryParentIds(list.get(0).getFolderId(), allFolder);
            parentIds.add(0,folderId);
            Collections.reverse(parentIds);
            for (Object parentId : parentIds) {
                BmFolder bmFolder=new BmFolder().selectById(parentId.toString());
                if (bmFolder!=null){
                    checkRespVo.getPath().add(bmFolder.getFolderName());
                }
            }
        }
        return checkRespVo;
    }

    /**
     * 获取最近访问的收藏
     *
     * @return
     * @param pageWrapper
     */
    @Override
    public List<BookmarkVo> recentVisited(PageWrapper pageWrapper) {
        PageHelper.startPage(pageWrapper.getPage(),pageWrapper.getLimit());
        List<BmBookmark> recentVisited = bmBookmarkMapper.getRecentVisited(oauth2Service.currentUser().getData().getInteger("id"));
        //对象转换
        return ObjectUtil.copyListProperties(recentVisited, BookmarkVo.class);
    }


    /**
     * 检测连接有效性
     *
     * @param folderId 收藏夹id
     * @return
     */
    @Override
    public CheckVo checkInvalidUrl(Integer folderId) {

        if (redisUtils.hasKey(REDIS_KEY + request.getHeader("access_token"))) {
            throw new CommonException("正在检测");
        }
        redisUtils.set(REDIS_KEY + request.getHeader("access_token"), 1, 30 * 60);
        if (folderId == null) {
            folderId = ROOT_ID;
        }
        LambdaQueryWrapper<BmBookmark> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(BmBookmark::getUserId, oauth2Service.currentUser().getData().getInteger("id"));
        //根节点查所有
        if (ROOT_ID != folderId) {
            lambdaQueryWrapper.eq(BmBookmark::getFolderId, folderId);
        }
        List<BmBookmark> bmBookmarks = new BmBookmark().selectList(lambdaQueryWrapper);
        CheckVo checkVo = new CheckVo(0, 0, 0);
        checkVo.setTotal(bmBookmarks.size());
        for (BmBookmark bmBookmark : bmBookmarks) {
            checkVo.setValid(true);
            //如果key不存在说明任务取消了
            if (!redisUtils.hasKey(REDIS_KEY + request.getHeader("access_token"))) {
                break;
            }
            int statusCode = 500;
            try {
                HttpResult httpResult = this.httpGet(bmBookmark.getUrl(), 0);
                statusCode = httpResult.getStatusCode();
                if (String.valueOf(statusCode).startsWith("4") || String.valueOf(statusCode).startsWith("5")) {
                    checkVo.setInvalidDataCount(checkVo.getInvalidDataCount() + 1);
                    checkVo.setValid(false);
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                //无响应
                checkVo.setInvalidDataCount(checkVo.getInvalidDataCount() + 1);
                checkVo.setValid(false);
                statusCode = 500;
            } finally {
                checkVo.setId(bmBookmark.getId());
                checkVo.setCheckedCount(checkVo.getCheckedCount() + 1);
                checkVo.setUrl(bmBookmark.getUrl());
                checkVo.setTitle(bmBookmark.getTitle());
                checkVo.setStatusCode(statusCode);
                //通知前端进度
                WebsocketVo websocketVo = new WebsocketVo();
                websocketVo.setTimestamp(System.currentTimeMillis());
                websocketVo.setMsgType("checkUrl");
                websocketVo.setMsg(checkVo);
                if (checkVo.getValid()) {
                    bmBookmark.setState(0);
                } else {
                    //如果链接是无效的则修改书签状态
                    bmBookmark.setState(1);
                }
                bmBookmark.updateById();
                try {
                    WebSocketServer.sendInfo(Result.success(websocketVo), request.getHeader("access_token"));
                } catch (IOException e) {
                    logger.error("websocket消息发送失败：{}", e.getMessage(), e);
                }
            }
        }
        redisUtils.del(REDIS_KEY + request.getHeader("access_token"));
        return checkVo;
    }

    /**
     * 取消检测
     */
    @Override
    public void cancelCheckInvalidUrl() {
        redisUtils.del(REDIS_KEY + request.getHeader("access_token"));
    }

    /**
     * 移动文件夹
     *
     * @param moves
     * @param pid
     * @return
     */
    @Override
    public Boolean moveBookmark(List<BatchVo> moves, Integer pid) {
        if (pid == null) {
            throw new CommonException(Result.ResultEnum.BAD_REQUEST.getInfo());
        }
        List<TreeVo> folderTree = new ArrayList<>();
        for (BatchVo move : moves) {
            if (BatchVo.TYPE_FOLDER.equals(move.getType())) {
                BmFolder bmFolder = new BmFolder().selectById(move.getId());
                if (bmFolder != null) {
                    //判断是否移动到了自己的子级
                    if (folderTree.isEmpty()) {
                        folderTree = this.getAllFolder();
                    }
                    //获得所有上级的id
                    List<Object> pids = TreeUtil.queryParentIds(pid, folderTree);
                    //判断是否是自己的子集
                    if (pids.contains(move.getId())) {
                        //如果是则把自己的下级和自己的上级相连（子级升级）
                        BmFolder updateFolder = new BmFolder();
                        updateFolder.setParentId(bmFolder.getParentId());
                        updateFolder.update(new LambdaQueryWrapper<BmFolder>()
                                .eq(BmFolder::getParentId, bmFolder.getId()));
                    }

                    bmFolder.setParentId(pid);
                    bmFolder.updateById();
                }
            } else if (BatchVo.TYPE_BOOKMARK.equals(move.getType())) {
                BmBookmark bmBookmark = new BmBookmark().selectById(move.getId());
                if (bmBookmark != null) {
                    bmBookmark.setFolderId(pid);
                    bmBookmark.updateById();
                }
            } else {
                logger.error("type不存在");
            }
        }
        return Boolean.TRUE;
    }
    /**
     * 保存访问历史
     *  @param id
     *
     */
    @Override
    public void saveHistory(Integer id) {
        BmBookmark bmBookmark = new BmBookmark().selectById(id);
        if (bmBookmark != null) {
            bmBookmark.setAccessCount(bmBookmark.getAccessCount()+1);
            bmBookmark.updateById();
            JSONObject data = oauth2Service.currentUser().getData();
            BmRecentVisited bmRecentVisited = new BmRecentVisited().selectOne(new LambdaQueryWrapper<BmRecentVisited>()
                    .eq(BmRecentVisited::getBookmarkId, id)
                    .eq(BmRecentVisited::getUserId,data.getInteger("id")));
            if (bmRecentVisited != null) {
                bmRecentVisited.setAccessTime(System.currentTimeMillis());
                bmRecentVisited.updateById();
            }else{
                bmRecentVisited=new BmRecentVisited();
                bmRecentVisited.setBookmarkId(bmBookmark.getId());
                bmRecentVisited.setUserId(data.getInteger("id"));
                bmRecentVisited.setAccessTime(System.currentTimeMillis());
                bmRecentVisited.insert();
            }
        }

    }
}
