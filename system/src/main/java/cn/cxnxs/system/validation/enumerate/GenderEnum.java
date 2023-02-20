package cn.cxnxs.system.validation.enumerate;

import cn.cxnxs.common.web.validation.AbsValid;

/**
 * 自定义 枚举-性别，实现接口，已支持 hibernate 校验器
 *
 * @author z.y
 * @version v1.0
 * @date 2022/7/19
 */
public enum GenderEnum implements AbsValid {
    /** 1 男 */M("1","男"),
    /** 2 女 */W("2","女"),
    /** 9 未知 */X("9","未知"),
    ;
    private final String key;
    private final String name;
    GenderEnum(String key,String name){
        this.key = key;
        this.name = name;
    }
    @Override
    public boolean eq(String val) {
        return key.equals(val);
    }
    @Override
    public String key() {
        return key;
    }
    public String getName() {
        return name;
    }
}
