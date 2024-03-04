package cn.cxnxs.scheduler.enums;

import freemarker.template.TemplateMethodModelEx;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

/**
 * 配置文件常量
 */
@Getter
public enum CustomMethods {

    INCREMENT("自增", "<#function increment num>\n" +
            "<#return num?number + 1>\n" +
            "</#function>"),
    DECREMENT("自减", "<#function decrement num>\n" +
            "<#return num?number - 1>\n\n" +
            "</#function>"),
    CONCAT("两个参数相加", "<#function concat param1 param2>\n" +
            "    <#if param1?is_number && param2?is_number>\n" +
            "        <#return param1 + param2>\n" +
            "    <#else>\n" +
            "        <#return param1 + param2>\n" +
            "    </#if>\n" +
            "</#function>"),
    GUID("生成uuid", "<#assign guid ='cn.cxnxs.scheduler.enums.CustomMethods$GuidMethod'?new()>"),
    ;
    private final String name;

    private final String template;

    CustomMethods(String name, String template) {
        this.name = name;
        this.template = template;
    }

    public static class GuidMethod implements TemplateMethodModelEx {
        @Override
        public Object exec(List arguments) {
            return UUID.randomUUID().toString().replaceAll("-", "");
        }
    }

    public static String getMethods() {
        StringBuilder tlp = new StringBuilder();
        for (CustomMethods value : CustomMethods.values()) {
            tlp.append(value.getTemplate()).append("\n");
        }
        return tlp.toString();
    }
}
