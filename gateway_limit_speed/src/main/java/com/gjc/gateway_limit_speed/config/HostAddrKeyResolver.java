package com.gjc.gateway_limit_speed.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class HostAddrKeyResolver implements KeyResolver {


    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        // 通过hostAddress 维度去限流判断
//        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
        // 通过用户的维度限流 参数
//        return Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
        // 通过用uri维度限流
        return Mono.just(exchange.getRequest().getURI().getPath());
    }

}


