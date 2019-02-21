package com.wangyuxuan;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/21 15:51
 * @Description:
 */

@SpringBootApplication
@EnableDubboConfiguration
public class Applicaiton {

    public static void main(String[] args) {
        SpringApplication.run(Applicaiton.class, args);
        System.out.println("complete");
    }
}
