package cn.cxnxs.system.mapper;

import cn.cxnxs.system.entity.OauthClientDetails;
import cn.cxnxs.system.vo.ClientDetailVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mengjinyuan
 * @since 2022-05-01
 */
public interface OauthClientDetailsMapper extends BaseMapper<OauthClientDetails> {

    List<ClientDetailVO> selectList(ClientDetailVO clientDetailVO);

}
