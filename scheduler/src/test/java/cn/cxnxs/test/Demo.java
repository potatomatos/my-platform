package cn.cxnxs.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        String jsonString = "{\n" +
                "    \"title\": {\n" +
                "      \"xpath\": \"//*[@id=\\\"mainContent\\\"]/div/div/div[2]/a/span\",\n" +
                "      \"value\": \"allText()\"\n" +
                "    },\n" +
                "    \"url\": {\n" +
                "      \"xpath\": \"//*[@id=\\\"mainContent\\\"]/div/div/div[2]/a\",\n" +
                "      \"value\": \"@href\"\n" +
                "    },\n" +
                "    \"next_url\": {\n" +
                "      \"css\": \"#homepage_bottom_pager .pager a:containsOwn(下一页)\",\n" +
                "      \"value\": \"@href\",\n" +
                "      \"repeat\": true\n" +
                "    }\n" +
                "  }";

        JSONObject jsonObject = JSONObject.parseObject(jsonString);

        List<String> keysWithRepeat = new ArrayList<>();
        jsonObject.entrySet().stream()
                .filter(entry -> entry.getValue() instanceof JSONObject)
                .forEach(entry -> {
                    boolean repeat = ((JSONObject) entry.getValue()).getBooleanValue("repeat");
                });
    }
}
