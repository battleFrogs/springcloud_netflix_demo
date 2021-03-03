package com.gjc.service_feign.controller;


import com.gjc.service_feign.feign.TestFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {


    @Resource
    private TestFeignService testFeignService;

    // 通过feign去实现调用，然后feign去调用eureka-client服务
    // 如果client 起了两个服务，默认实现负载均衡
    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return testFeignService.sayHiFromClientOne(name);
    }

    // 通过 zuul分发过来的请求
    @GetMapping(value = "/who")
    public String who() {
        return "我是feign";
    }

}
