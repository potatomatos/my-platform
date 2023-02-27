package cn.cxnxs.bookmark.mapper;

import cn.cxnxs.bookmark.entity.BmUsers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author mengjinyuan
 * @since 2022-02-17
 */
public interface BmUsersMapper extends BaseMapper<BmUsers> {
    /**
     * 获取登录用户
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    @Select("select * from bm_users where (username=#{username} and encrypted_password=#{password}) or (email=#{username} and encrypted_password=#{password})")
    BmUsers selectLoginUser(String username, String password);
}
