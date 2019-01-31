package com.wangyuxuan.demo.controller;

import com.wangyuxuan.demo.bean.BlogProperties;
import com.wangyuxuan.demo.bean.ConfigBean;
import com.wangyuxuan.demo.bean.TestConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangyuxuan
 * @Date: 2019/1/31 14:36
 * @Description:
 */

@RestController
public class IndexController {

    @Autowired
    private BlogProperties blogProperties;
    @Autowired
    private ConfigBean configBean;
    @Autowired
    private TestConfigBean testConfigBean;

    @RequestMapping("/")
    public String index() {
//        return blogProperties.getName() + "——" + blogProperties.getTitle();
//        return configBean.getName() + "——" + configBean.getTitle();
        return testConfigBean.getName() + "，" + testConfigBean.getAge();
    }
}
