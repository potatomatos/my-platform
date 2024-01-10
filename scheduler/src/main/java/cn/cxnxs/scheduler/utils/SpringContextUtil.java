package cn.cxnxs.scheduler.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 功能描述：获取spring容器，以访问容器中定义的其他bean
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(SpringContextUtil.class);

    /**
     * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候中取出ApplicaitonContext.
     */
    // Spring应用上下文环境
    private static ApplicationContext applicationContext;
    // Spring应用上下文环境
    private static SpringContextUtil instance = new SpringContextUtil();


    public SpringContextUtil() {
        instance = this;
    }

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     *
     * @param applicationContext
     * @throws BeansException
     */

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }


    /**
     * 获取对象
     *
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {

        return SpringContextUtil.applicationContext.getBean(name);

    }


    public static <T> T getBean(Class<T> clazz) {
        T t = null;
        try {
            logger.info("get Bean from spring :" + clazz.getSimpleName());
            t = SpringContextUtil.applicationContext.getBean(clazz);
        } catch (NoSuchBeanDefinitionException e) {
            try {
                t = initBeanToSpring(clazz);
            } catch (Exception ex) {
                logger.info("add Bean To Spring error :" + ex);
            }
        }
        return t;
    }

    @SuppressWarnings("unchecked")
    public synchronized static <T> T initBeanToSpring(Class<T> clazz) {
        String nameString = (clazz.getSimpleName().substring(0, 1)).toLowerCase() + clazz.getSimpleName().substring(1);
        boolean containsBean = SpringContextUtil.applicationContext.containsBean(nameString);
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) SpringContextUtil.applicationContext.getAutowireCapableBeanFactory();

        Object result;
        if (!containsBean) {
            //创建bean信息.
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
            beanDefinitionBuilder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
            //动态注册bean
            defaultListableBeanFactory.registerBeanDefinition(nameString, beanDefinitionBuilder.getBeanDefinition());
            logger.info("add Bean [" + nameString + "] To Spring :" + clazz.toString());
        }

        try {
            result = applicationContext.getBean(nameString);
        } catch (NoSuchBeanDefinitionException e) {
            logger.info("register Bean finished, but still not find bean from Spring : [" + nameString + "]" + clazz.toString());
            throw e;
        }
        return (T) result;
    }


    /**
     * 获取类型为requiredType的对象
     * 如果bean不能被类型转换，相应的异常将会被抛出（BeanNotOfRequiredTypeException）
     *
     * @param name         bean注册名
     * @param requiredType 返回对象类型
     * @return Object 返回requiredType类型对象
     * @throws BeansException
     */
    public static Object getBean(String name, Class requiredType)
            throws BeansException {
        return applicationContext.getBean(name, requiredType);
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     *
     * @param name
     * @return boolean
     */
    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    /**
     * 如果BeanFactory包含一个与所给类的bean定义，则返回true
     *
     * @param clazz
     * @return boolean
     */
    public static <T> boolean containsBean(Class<T> clazz) {
        String nameString = clazz.getSimpleName();
        nameString = (nameString.substring(0, 1)).toLowerCase() + nameString.substring(1);
        return applicationContext.containsBean(nameString);
    }

    /**
     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     *
     * @param name
     * @return boolean
     * @throws NoSuchBeanDefinitionException
     */
    public static boolean isSingleton(String name)
            throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(name);
    }

    /**
     * @param name
     * @return Class 注册对象的类型
     * @throws NoSuchBeanDefinitionException
     */
    public static Class getType(String name)
            throws NoSuchBeanDefinitionException {
        return applicationContext.getType(name);
    }

    /**
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
     *
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    public static String[] getAliases(String name)
            throws NoSuchBeanDefinitionException {
        return applicationContext.getAliases(name);
    }
}
