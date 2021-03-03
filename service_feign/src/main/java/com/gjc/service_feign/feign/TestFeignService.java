package com.gjc.service_feign.feign;

import com.gjc.service_feign.feign.impl.TestFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


// feign 消费是通过注解的方式进行的消费模式，它默认打开了负载均衡；
// 声明feign服务
@FeignClient(value = "client", fallback = TestFeignServiceImpl.class)
public interface TestFeignService {


    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);


}
