package cn.cxnxs.gateway.filter;

import cn.cxnxs.common.core.entity.response.Result;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <p>统一鉴权过滤器</p>
 *
 * @author mengjinyuan
 * @date 2022-12-03 22:53
 **/
@Slf4j
@Component
public class PermissionFilter implements GlobalFilter, Ordered {

    @Autowired
    private WebClient.Builder webBuilder;

    private final PathMatcher matcher = new AntPathMatcher();


    /**
     * 执行过滤器中的过滤逻辑
     *
     * @param exchange
     * @param chain
     * @return
     */
    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String accessToken = exchange.getRequest().getHeaders().getFirst("access_token");
        String url = exchange.getRequest().getURI().getPath();
        log.info("访问地址：{}, token: {}", url, accessToken);

        List<String> list = Lists.newArrayList();
        list.add("/oauth-server/oauth/**");
        list.add("/oauth-server/captcha");
        list.add("/oauth-server/rsa/publicKey");
        list.add("/oauth-server/login");
        list.add("/oauth-server/verifyPage");
        list.add("/system/system/api/getAccessToken");
        list.add("/cloud-disk/system/getAccessToken");

        boolean match = false;
        for (String path : list) {
            if (matcher.match(path,url)) {
                match = true;
            }
        }
        if (!match) {
            if (accessToken == null) {
                return this.setUnauthorizedResponse(exchange, Result.failure(Result.ResultEnum.NEED_LOGIN, null));
            } else {
                CompletableFuture<Result<Object>> completableFuture = CompletableFuture.supplyAsync(()-> {
                    Mono<Result> userMono = webBuilder.baseUrl("http://oauth-server")
                            .build().get().uri("/verifyToken")
                            .header("access_token",accessToken)
                            .retrieve().bodyToMono(Result.class);
                    return userMono.block();
                });
                Result result;
                try {
                    result = completableFuture.get();
                } catch (InterruptedException e) {
                    throw e;
                } catch (ExecutionException e) {
                    log.error(e.getMessage(),e);
                    return this.setUnauthorizedResponse(exchange, Result.failure("token校验失败，请重新登录"));
                }
                if (!Result.ResultEnum.SUCCESS.getCode().equals(result.getCode())) {
                     return this.setUnauthorizedResponse(exchange, result);
                }
            }
        }
        // 设置用户信息到请求
        ServerHttpRequest mutableReq = exchange.getRequest()
                .mutate().header("access_token", accessToken)
                .build();
        ServerWebExchange mutableExchange = exchange.mutate().request(mutableReq).build();
        return chain.filter(mutableExchange);
    }

    private Mono<Void> setUnauthorizedResponse(ServerWebExchange exchange, Result msg) {
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        response.setStatusCode(HttpStatus.OK);

        log.error("[鉴权异常处理]请求路径:{}", exchange.getRequest().getPath());

        return response.writeWith(Mono.fromSupplier(() -> {
            DataBufferFactory bufferFactory = response.bufferFactory();
            return bufferFactory.wrap(JSON.toJSONBytes(msg));
        }));
    }

    /**
     * 指定过滤器执行顺序,返回值越小，执行优先级越高
     */
    @Override
    public int getOrder() {
        return -200;
    }
}
