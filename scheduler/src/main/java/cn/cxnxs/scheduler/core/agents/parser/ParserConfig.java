package cn.cxnxs.scheduler.core.agents.parser;


import cn.cxnxs.scheduler.core.http.ContentType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>配置类</p>
 *
 * @author mengjinyuan
 * @date 2021-09-10 16:45
 **/
@Configuration
public class ParserConfig {

    @Bean
    public HTMLParser htmlParser() {
        return new HTMLParser(ContentType.HTML, "html解析器");
    }

    @Bean
    public JSONParser jsonParser() {
        return new JSONParser(ContentType.JSON, "json解析器");
    }

    @Bean
    public XMLParser xmlParser() {
        return new XMLParser(ContentType.XML, "xml解析器");
    }

    @Bean
    public TextParser textParser() {
        return new TextParser(ContentType.TEXT, "文本解析器");
    }

}
