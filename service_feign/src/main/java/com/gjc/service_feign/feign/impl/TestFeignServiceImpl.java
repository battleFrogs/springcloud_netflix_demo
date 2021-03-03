package com.gjc.service_feign.feign.impl;

import com.gjc.service_feign.feign.TestFeignService;
import org.springframework.stereotype.Component;

@Component
public class TestFeignServiceImpl implements TestFeignService {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

}
