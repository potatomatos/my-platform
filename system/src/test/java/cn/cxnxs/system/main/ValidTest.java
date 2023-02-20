package cn.cxnxs.system.main;

import cn.cxnxs.system.entity.ValidBean;
import org.hibernate.validator.HibernateValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 测试校验
 *
 * @author z.y
 * @version v1.0
 * @date 2022/7/19
 */
public class ValidTest {
    public static void main(String[] args) {
        Validator validator = Validation.byProvider(HibernateValidator.class)
                .configure().failFast(true).buildValidatorFactory().getValidator();
        ValidBean bean = new ValidBean().id(1L).name("a").gender("1");
        valid(validator,bean);
        bean = new ValidBean().id(1L).name("b").gender("3");
        valid(validator,bean);
        bean = new ValidBean().id(null).name(null).gender(null);
        valid(validator,bean);
    }
    public static <T> void valid(Validator validator,T t){
        System.out.println("start:"+t);
        Set<ConstraintViolation<T>> vs = validator.validate(t);
        if( null == vs || vs.isEmpty()){
            System.out.println("通过");
        }else {
            for (ConstraintViolation<T> v : vs) {
                System.out.println("异常："+v.getMessage());
            }
        }
        System.out.println("end<<<<");
    }
}
