package cn.cxnxs.common.web.utils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.hibernate.validator.HibernateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
public class ValidationUtil{
    private static final Logger logger = LoggerFactory.getLogger(ValidationUtil.class);
    /** 使用hibernate的注解来进行验证-spring注入 */
    @Resource
    private Validator validator;

    public <T> void validateBean(T t){
        logger.debug("使用HibernateValidator校验实体类, {}",t);
        Set<ConstraintViolation<T>> validate = validator.validate(t);
        if(!validate.isEmpty()){
            List<String> list = validate.stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
            logger.debug("使用HibernateValidator校验实体类-, {}",list);
            throw new RuntimeException(list.get(0));
        }
    }

    /** 使用hibernate的注解来进行验证-静态引入 */
    private static final Validator validate = Validation.byProvider(HibernateValidator.class).configure()
            .failFast(true).buildValidatorFactory().getValidator();

    public static <T> void validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validate.validate(obj);
        // 抛出检验异常
        if (constraintViolations.size() > 0) {
            throw new RuntimeException(String.format("0001参数校验失败:%s",
                    constraintViolations.iterator().next().getMessage()));
        }
    }
}
