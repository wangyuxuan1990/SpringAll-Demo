package com.wangyuxuan.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wangyuxuan.common.api.HelloService;
import org.springframework.stereotype.Component;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/21 15:56
 * @Description:
 */

@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String message) {
        return "hello," + message;
    }
}
