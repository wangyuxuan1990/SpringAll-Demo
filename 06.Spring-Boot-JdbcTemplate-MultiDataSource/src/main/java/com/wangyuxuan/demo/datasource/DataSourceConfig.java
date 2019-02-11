package com.wangyuxuan.demo.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/11 15:22
 * @Description:
 */

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "dataSourceOne")
    @ConfigurationProperties("spring.datasource.druid.mysqlone")
    public DataSource dataSourceOne(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "dataSourceTwo")
    @ConfigurationProperties("spring.datasource.druid.mysqltwo")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("dataSourceOne") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("dataSourceTwo") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
