package cn.cxnxs.test;

import com.alibaba.fastjson.JSONObject;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringReader;
import java.io.StringWriter;

public class FreeMarkerDemo {
    public static void main(String[] args) {
        try {
            // 创建Freemarker配置实例
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);

            // 定义模板字符串
            String templateString = "Hello, ${name}!";

            // 使用StringReader从字符串创建模板
            Template template = new Template("name", new StringReader(templateString), cfg);

            // 准备数据模型
            JSONObject dataModel = new JSONObject();
            dataModel.put("name", "World");

            // 渲染模板
            StringWriter out = new StringWriter();
            template.process(dataModel, out);

            // 输出结果
            System.out.println(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
