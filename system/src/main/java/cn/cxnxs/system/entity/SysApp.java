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
public class SysApp extends Model<SysApp> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String clientId;
    private String appName;
    private String index;
    private Long createdAt;
    private Long updatedAt;
}
