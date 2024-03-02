package cn.cxnxs.scheduler.core.agents;

import cn.cxnxs.scheduler.core.Event;
import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.core.SingleSourceAgent;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Objects;
import java.util.Properties;

/**
 * 发送邮件任务
 */
@Component
@Scope("prototype")
@Slf4j
public class EmailAgent extends SingleSourceAgent {

    @Override
    public void start(RunResult runResult) throws Exception {
        long start = System.currentTimeMillis();
        Event event = getEvent();
        if (Objects.nonNull(event)) {
            JSONObject options = getOptions();
            JSONObject config = options.getJSONObject("config");
            final String username = config.getString("username");
            final String password = config.getString("password");
            final String to = config.getString("to");
            final String type = options.getString("type");
            final String subject = options.getString("subject");
            final String body = options.getString("body");

            Properties props = new Properties();
            props.put("mail.smtp.auth", config.getString("auth"));
            props.put("mail.smtp.starttls.enable", config.getString("enableStarttls"));
            props.put("mail.smtp.host", config.getString("host"));
            props.put("mail.smtp.port", config.getString("port"));

            final Session session;
            if (config.getBooleanValue("auth")) {
                session = Session.getInstance(props, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
            } else {
                session = Session.getInstance(props);
            }

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent(body, type);
            Transport.send(message);
            runResult.info("邮件发送完成，from:{},to:{},用时：{}", username, to, System.currentTimeMillis() - start);
        }
    }
}
