package cn.cxnxs.system.service;

import cn.cxnxs.common.api.system.domain.UserApiEntity;
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

    Integer logicDelUser(Integer userId);

    UserVO getUser(Integer userId);

    List<RoleVO> selectUserRoles(RoleVO roleVO);

    UserApiEntity getUserByName(String username);

    Boolean resetPassword(Integer userId);
}
