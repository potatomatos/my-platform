package cn.cxnxs.system.entity;

import cn.cxnxs.system.validation.annotation.EnumValid;
import cn.cxnxs.system.validation.enumerate.GenderEnum;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 校验测试实体
 *
 * @author z.y
 * @version v1.0
 * @date 2022/7/19
 */
@Validated
public class ValidBean {
    @NotNull (message = "id不能为null")
    private Long id;
    @NotBlank (message = "name不能为空")
    private String name;
    @NotBlank(message = "gender不能为空")
    @EnumValid(enumClass = GenderEnum.class, message = "gender非法")
    private String gender;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ValidBean id(Long id) { this.id = id; return this; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public ValidBean name(String name) { this.name = name;return this; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public ValidBean gender(String gender) { this.gender = gender;return this; }

    @Override
    public String toString() {
        return "ValidBean{id=" + id + ", name='" + name + "', gender='" + gender + "'}";
    }
}
