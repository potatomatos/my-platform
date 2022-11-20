package cn.cxnxs.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class SysDict extends Model<SysDict> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String dictType;
    private String code;
    private String label;
    private Integer state;
    private Integer sort;
    private Long createdAt;
    private Long updatedAt;
}
