package cn.cxnxs.common.api.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * <p>全局拦截器</p>
 *
 * @author mengjinyuan
 * @date 2022-12-04 01:28
 **/
@Component
public class FeignInterceptor implements RequestInterceptor {

    /**
     * 传递header请求头
     *
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    String values = request.getHeader(name);
                    // 跳过 content-length
                    if ("content-length".equals(name)) {
                        continue;
                    }
                    requestTemplate.header(name, values);
                }
            }
        }
    }

}
