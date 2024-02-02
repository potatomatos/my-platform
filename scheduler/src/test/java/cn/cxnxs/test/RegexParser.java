package cn.cxnxs.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParser {
    public static List<List<String>> parseNextUrl(String input) {
        List<String> fullMatchList = new ArrayList<>();
        List<String> textMatchList = new ArrayList<>();
        Pattern pattern = Pattern.compile("#\\{\\s*(.*?)\\s*\\}");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            fullMatchList.add(matcher.group(0)); // 整个 #{ next_url } 内容
            textMatchList.add(matcher.group(1)); // next_url 这个文本
        }
        List<List<String>> resultList = new ArrayList<>();
        resultList.add(fullMatchList);
        resultList.add(textMatchList);
        return resultList;
    }

    public static void main(String[] args) {
        String input = "{\n" +
                "  \"url\": \"https://www.cnblogs.com/mokou\", \"url_from_event\": \"#{ next_url }\", \"method\": \"get\", \"type\": \"html\", \"mode\": \"on_change\", \"extract\": { \"title\": { \"xpath\": \"//*[@id=\\\"mainContent\\\"]/div/div/div[2]/a/span\", \"value\": \"allText()\" }, \"url\": { \"xpath\": \"//*[@id=\\\"mainContent\\\"]/div/div/div[2]/a\", \"value\": \"@href\" } }\n" +
                "}";
        List<List<String>> result = parseNextUrl(input);
        System.out.println(result);
    }
}
