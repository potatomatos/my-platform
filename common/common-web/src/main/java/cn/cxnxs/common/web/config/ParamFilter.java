package cn.cxnxs.common.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.*;

/**
 * <p>参数拦截</p>
 *
 * @author mengjinyuan
 * @date 2022-04-01 10:33
 **/
@Slf4j
@WebFilter(urlPatterns = "/*", filterName = "paramFilter")
public class ParamFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        String token=httpServletRequest.getParameter("token");
        if (!StringUtils.isEmpty(token)){
            log.info("======token拦截过滤======");
            HeaderRequestWrapper httpServletRequestWrapper = new HeaderRequestWrapper(httpServletRequest);
            httpServletRequestWrapper.addHeader("token", token);
            filterChain.doFilter(httpServletRequestWrapper, servletResponse);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private static class HeaderRequestWrapper extends HttpServletRequestWrapper {

        public HeaderRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        private final Map<String, String> headerMap = new HashMap<>();

        public void addHeader(String name, String value) {
            this.headerMap.put(name, value);
        }

        @Override
        public String getHeader(String name) {
            String headerValue = super.getHeader(name);
            if (this.headerMap.containsKey(name)) {
                headerValue = this.headerMap.get(name);
            }
            return headerValue;
        }

        @Override
        public Enumeration<String> getHeaderNames() {
            List<String> names = Collections.list(super.getHeaderNames());
            names.addAll(this.headerMap.keySet());
            return Collections.enumeration(names);
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            List<String> values = Collections.list(super.getHeaders(name));
            if (this.headerMap.containsKey(name)) {
                values = Arrays.asList(this.headerMap.get(name));
            }
            return Collections.enumeration(values);
        }

    }

}
