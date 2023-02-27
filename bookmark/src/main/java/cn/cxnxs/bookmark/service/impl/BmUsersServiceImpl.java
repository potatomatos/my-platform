package cn.cxnxs.bookmark.service.impl;

import cn.cxnxs.bookmark.entity.BmUsers;
import cn.cxnxs.bookmark.mapper.BmUsersMapper;
import cn.cxnxs.bookmark.service.IBmUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author mengjinyuan
 * @since 2022-02-17
 */
@Service
public class BmUsersServiceImpl extends ServiceImpl<BmUsersMapper, BmUsers> implements IBmUsersService {

}
