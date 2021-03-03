package com.gjc.service_ribbon.service.impl;

import com.gjc.service_ribbon.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestServiceImpl implements TestService {

    // 使用“RestTemplate + ribbon”方式配置消费时，当我们将 RestTemplate 通过 @Autowired 注解注入到一个类中，
    // 启动服务就可能会报该错误 , 后续版本需要手动启动RestTemplate的配置bean
    @Autowired
    private RestTemplate restTemplate;


    // 而 ribbon 消费需要手动配置负载均衡；
    @HystrixCommand(fallbackMethod = "hiError")  // 该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
    @Override
    public String hiService(String name) {
        // 通过restTemplate消费clinet 服务的/hi接口 ,注意 client的服务名大写（或与注册中心中一致）
        return restTemplate.getForObject("http://CLIENT/hi?name=" + name, String.class);
    }


    public String hiError(String name) {
        return "hi," + name + ",sorry,error";
    }


}
