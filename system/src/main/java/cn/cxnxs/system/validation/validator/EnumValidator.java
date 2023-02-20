package cn.cxnxs.system.validation.validator;

import cn.cxnxs.common.web.validation.AbsValid;
import cn.cxnxs.system.validation.annotation.EnumValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义校验器
 *
 * @author z.y
 * @version v1.0
 * @date 2022/7/19
 */
public class EnumValidator implements ConstraintValidator<EnumValid,String> {
    private Class<? extends Enum<? extends AbsValid>> enumClass;
    private Enum<? extends AbsValid>[] ecs;
    @Override
    public void initialize(EnumValid ca) {
        enumClass = ca.enumClass();
        // 获取枚举列表
        ecs = enumClass.getEnumConstants();
    }
    @Override
    public boolean isValid(String val, ConstraintValidatorContext cvc) {
        if( null == val || val.isEmpty() ){ return true; }
        if( null == enumClass || null == ecs){ return true; }
        for (Enum<? extends AbsValid> ec : ecs) {
            if(((AbsValid) ec).eq(val)){ return true; }
        }
        return false;
    }
}

