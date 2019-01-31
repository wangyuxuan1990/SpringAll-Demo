package com.wangyuxuan.demo.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: wangyuxuan
 * @Date: 2019/1/31 14:33
 * @Description:
 */

@Getter
@Setter
@Component
public class BlogProperties {

    @Value("${wangyuxuan.blog.name}")
    private String name;
    @Value("${wangyuxuan.blog.title}")
    private String title;
}
