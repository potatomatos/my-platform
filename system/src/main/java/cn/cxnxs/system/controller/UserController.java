package cn.cxnxs.system.controller;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.system.service.IUserService;
import cn.cxnxs.system.vo.PageVO;
import cn.cxnxs.system.vo.UserVO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户相关接口
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("list")
    public PageVO<UserVO> selectUsersForPage(@RequestBody PageWrapper<UserVO> wrapper) {
        return userService.selectUsersForPage(wrapper);
    }

    @ResponseResult
    @GetMapping("/{id}")
    public UserVO selectOne(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @ResponseResult
    @PostMapping("add")
    public Integer add(@RequestBody UserVO userVO) {
        return userService.addUser(userVO);
    }

    @ResponseResult
    @PostMapping("update")
    public Integer update(@RequestBody UserVO userVO) {
        return userService.updateUser(userVO);
    }

    @ResponseResult
    @PostMapping("del/{id}")
    public Integer del(@PathVariable("id") Integer id) {
        return userService.logicDelUser(id);
    }

    @ResponseResult
    @PostMapping("resetPassword/{id}")
    public Boolean resetPassword(@PathVariable("id") Integer id) {
        return userService.resetPassword(id);
    }

    @ResponseResult
    @PostMapping("updatePassword")
    public Boolean updatePassword(@RequestBody UserVO userVO) {
        return userService.updatePassword(userVO.getId(),userVO.getPassword());
    }

    @PostMapping("avatar/upload")
    public Result<String> uploadAvatar(@RequestParam("file") MultipartFile file){
        String avatar = userService.uploadAvatar(file);
        Result<String> success = Result.success();
        success.setData(avatar);
        return success;
    }
}
