package com.wangyuxuan.demo.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: wangyuxuan
 * @Date: 2019/1/31 14:43
 * @Description:
 */

@Getter
@Setter
@ConfigurationProperties(prefix = "wangyuxuan.blog")
public class ConfigBean {

    private String name;
    private String title;
}
