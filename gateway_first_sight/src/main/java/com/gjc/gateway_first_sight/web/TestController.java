package com.gjc.gateway_first_sight.web;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

//@Configuration
//@RestController
//public class TestController {
//
//
//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        String httpUri = "http://httpbin.org:80";
//        return builder.routes()
//                .route(p -> p
//                        .path("/get") // 将请求 /get 转发到 指定url 和 修改添加请求头
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri(httpUri))
//                .route(p -> p
//                        // 断言请求是否进入该路由，当请求的host有“*.hystrix.com”，都会进入该router，
//                        // 该router中有一个hystrix的filter,该filter可以配置名称、
//                        // 和指向性fallback的逻辑的地址，
//                        // 比如本案例中重定向到了“/fallback
//                        .host("*.hystrix.com")
//                        .filters(f -> f
//                                .hystrix(config -> config
//                                        .setName("mycmd")
//                                        .setFallbackUri("forward:/fallback")))
//                        .uri(httpUri))
//                .build();
//    }
//
//
//    // 重定向fallback到的位置
//    @RequestMapping("/fallback")
//    public Mono<String> fallback() {
//        return Mono.just("fallback");
//    }
//
//
//}
