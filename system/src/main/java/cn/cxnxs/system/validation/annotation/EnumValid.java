package cn.cxnxs.system.validation.annotation;

import cn.cxnxs.common.web.validation.AbsValid;
import cn.cxnxs.system.validation.validator.EnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义校验注解-枚举
 */
@Constraint (validatedBy = EnumValidator.class)
@Retention (RetentionPolicy.RUNTIME)
@Target ({ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.METHOD})
public @interface EnumValid {
    /** 提示信息，必须使用message命名，否则hibernate获取不到提示信息 */
    String message() default "值不匹配";
    /** 分组 */
    Class<?>[] groups() default {};
    /** 负载 */
    Class<? extends Payload>[] payload() default {};
    /** 枚举类,通过接口替代反射方式 */
    Class<? extends Enum<? extends AbsValid>> enumClass();
}
