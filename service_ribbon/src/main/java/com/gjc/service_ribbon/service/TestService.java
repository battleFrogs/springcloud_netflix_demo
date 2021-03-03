package com.gjc.service_ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public interface TestService {
    @HystrixCommand(fallbackMethod = "hiError")  // 该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
    String hiService(String name);
}
