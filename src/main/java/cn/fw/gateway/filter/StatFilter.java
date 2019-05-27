package cn.fw.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * 统计过滤器
 *
 * @author demo
 * @date 2018-05-20
 */
@Slf4j
@Component
public class StatFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Long time = LogCounter.end();
        Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        URI uri = exchange.getRequest().getURI();
        if (exchange.getResponse().getStatusCode() == HttpStatus.OK) {
            log.info("serverId:[{}],path:[{}]方法调用耗时：{}", route.getId(), uri.getPath(), time);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 99;
    }
}
