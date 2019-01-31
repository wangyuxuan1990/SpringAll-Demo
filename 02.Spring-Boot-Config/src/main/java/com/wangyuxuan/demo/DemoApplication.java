package com.wangyuxuan.demo;

import com.wangyuxuan.demo.bean.ConfigBean;
import com.wangyuxuan.demo.bean.TestConfigBean;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class, TestConfigBean.class})
//@ImportResource({"classpath:some-application.xml"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        //关闭banner
//        SpringApplication app = new SpringApplication(DemoApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);
        //不想项目的配置被命令行修改
//        SpringApplication app = new SpringApplication(DemoApplication.class);
//        app.setAddCommandLineProperties(false);
//        app.run(args);
    }

}

