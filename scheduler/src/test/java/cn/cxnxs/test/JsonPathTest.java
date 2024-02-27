package cn.cxnxs.test;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import java.util.List;

public class JsonPathTest {

    public static void main(String[] args) {
        String json = "{ \"results\": {" +
                "    \"data\": [" +
                "      {" +
                "        \"title\": \"Lorem ipsum 1\"," +
                "        \"description\": \"Aliquam pharetra leo ipsum.\"," +
                "        \"price\": 8.95" +
                "      }," +
                "      {" +
                "        \"title\": \"Lorem ipsum 2\"," +
                "        \"description\": \"Suspendisse a pulvinar lacus.\"," +
                "        \"price\": 12.99" +
                "      }," +
                "      {" +
                "        \"title\": \"Lorem ipsum 3\"," +
                "        \"description\": \"Praesent ac arcu tellus.\"," +
                "        \"price\": 8.99" +
                "      }" +
                "    ]" +
                "  }" +
                "}";
        ReadContext context = JsonPath.parse(json);
        List<String> titles = context.read("$.results.data[*].title");
        List<String> description = context.read("$.results.data[*].description");
        System.out.println(titles);
        System.out.println(description);
    }
}
