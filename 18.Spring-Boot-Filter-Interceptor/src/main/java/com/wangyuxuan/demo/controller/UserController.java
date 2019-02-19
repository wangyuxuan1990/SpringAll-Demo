package com.wangyuxuan.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/19 09:36
 * @Description:
 */

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("/{id:\\d+}")
    public void get(@PathVariable String id) {
//        throw new RuntimeException("user not exist");
        System.out.println(id);
    }
}
