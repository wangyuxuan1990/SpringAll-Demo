package com.wangyuxuan.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wangyuxuan.common.api.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/21 16:05
 * @Description:
 */

@RestController
public class HelloController {

    @Reference
    private HelloService helloService;

    @GetMapping("/hello/{message}")
    public String hello(@PathVariable String message) {
        return this.helloService.hello(message);
    }
}
