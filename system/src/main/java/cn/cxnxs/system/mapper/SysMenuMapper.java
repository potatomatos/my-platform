package cn.cxnxs.system.mapper;

import cn.cxnxs.system.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author mengjinyuan
 * @since 2022-05-01
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    @Select("SELECT a.* FROM sys_menu a JOIN sys_role_menu b ON a.id = b.menu_id JOIN sys_user_role c ON b.role_id = c.role_id AND c.user_id = #{userId} and a.state=0")
    List<SysMenu> getUserMenus(Integer userId);

}
