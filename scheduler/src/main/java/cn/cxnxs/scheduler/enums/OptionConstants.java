package cn.cxnxs.scheduler.enums;

/**
 * 配置文件常量
 */
public class OptionConstants {

    /**
     * 自增
     */
    public static final String INCREMENT = "<#function increment num>\n" +
            "<#return num + 1>\n" +
            "</#function>\n";

    /**
     * 自减
     */
    public static final String DECREMENT = "<#function decrement num>\n" +
            "    <#return num - 1>\n" +
            "</#function>\n";


    /**
     * 两个参数相加
     */
    public static final String CONCAT = "<#function concat param1 param2>\n" +
            "    <#if param1?is_number && param2?is_number>\n" +
            "        <#return param1 + param2>\n" +
            "    <#else>\n" +
            "        <#return param1 + param2>\n" +
            "    </#if>\n" +
            "</#function>\n";
}
