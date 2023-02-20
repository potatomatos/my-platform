package cn.cxnxs.common.web.validation;

/**
 * 枚举接口，主要是固定方法eq
 */
public interface AbsValid {
    /**
     * 校验 值
     * @param val 待校验值
     * @return 状态
     */
    boolean eq(String val);
    /**
     * 获取枚举key
     * @return 枚举key
     */
    String key();
}

