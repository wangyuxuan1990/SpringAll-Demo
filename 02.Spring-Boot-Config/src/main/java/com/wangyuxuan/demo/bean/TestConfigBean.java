package com.wangyuxuan.demo.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: wangyuxuan
 * @Date: 2019/1/31 15:20
 * @Description:
 */

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "test")
@PropertySource("classpath:test.properties")
@Component
public class TestConfigBean {

    private String name;
    private int age;
}
