package com.gjc.service_ribbon.controller;

import com.gjc.service_ribbon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return testService.hiService(name);
    }

    // 通过 zuul分发过来的请求
    @GetMapping(value = "/who")
    public String who() {
        return "我是ribbon";
    }
}
