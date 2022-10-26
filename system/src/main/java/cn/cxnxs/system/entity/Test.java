package cn.cxnxs.system.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-10-26 22:50
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class Test extends Model<Test> {

    private Integer id;

    private String username;

}
