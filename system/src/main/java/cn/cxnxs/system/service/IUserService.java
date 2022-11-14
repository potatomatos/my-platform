package cn.cxnxs.system.service;

import cn.cxnxs.common.api.domain.UserApiEntity;
import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.system.vo.PageVO;
import cn.cxnxs.system.vo.RoleVO;
import cn.cxnxs.system.vo.UserVO;

import java.util.List;

public interface IUserService {

    PageVO<UserVO> selectUsersForPage(PageWrapper<UserVO> wrapper);

    Integer updateUser(UserVO userVO);

    Integer addUser(UserVO userVO);

    Integer delUser(Integer userId);

    PageVO<List<RoleVO>> selectUserRoles(PageWrapper<RoleVO> wrapper);

    UserApiEntity getUserByName(String username);
}
