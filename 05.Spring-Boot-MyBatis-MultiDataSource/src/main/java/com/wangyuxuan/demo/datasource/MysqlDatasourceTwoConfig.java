package com.wangyuxuan.demo.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/11 10:49
 * @Description:
 */

@Configuration
@MapperScan(basePackages = MysqlDatasourceTwoConfig.PACKAGE, sqlSessionFactoryRef = "mysqlSqlSessionFactoryTwo")
public class MysqlDatasourceTwoConfig {

    /**
     * mysqldao扫描路径
     */
    static final String PACKAGE = "com.wangyuxuan.demo.mysqltwodao";
    /**
     * mybatis mapper扫描路径
     */
    static final String MAPPER_LOCATION = "classpath:mapper/two/*.xml";

    @Bean(name = "mysqlDataSourceTwo")
    @ConfigurationProperties("spring.datasource.druid.mysqltwo")
    public DataSource mysqlDataSourceTwo() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlTransactionManagerTwo")
    public DataSourceTransactionManager mysqlTransactionManagerTwo() {
        return new DataSourceTransactionManager(mysqlDataSourceTwo());
    }

    @Bean(name = "mysqlSqlSessionFactoryTwo")
    public SqlSessionFactory mysqlSqlSessionFactoryTwo(@Qualifier("mysqlDataSourceTwo") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MysqlDatasourceTwoConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
