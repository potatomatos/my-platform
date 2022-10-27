package cn.cxnxs.system.service;

import cn.cxnxs.common.web.vo.request.PageWrapper;
import cn.cxnxs.system.vo.PageVO;
import cn.cxnxs.system.vo.RoleVO;
import cn.cxnxs.system.vo.UserVO;

import java.util.List;

public interface IUserService {

    PageVO<List<UserVO>> selectUsersForPage(PageWrapper<UserVO> wrapper);

    Integer updateUser(UserVO userVO);

    Integer addUser(UserVO userVO);

    Integer addUser(Integer userId);

    PageVO<List<RoleVO>> selectUserRoles(PageWrapper<RoleVO> wrapper);
}
