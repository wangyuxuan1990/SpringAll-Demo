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
@MapperScan(basePackages = MysqlDatasourceOneConfig.PACKAGE, sqlSessionFactoryRef = "mysqlSqlSessionFactoryOne")
public class MysqlDatasourceOneConfig {

    /**
     * mysqldao扫描路径
     */
    static final String PACKAGE = "com.wangyuxuan.demo.mysqlonedao";
    /**
     * mybatis mapper扫描路径
     */
    static final String MAPPER_LOCATION = "classpath:mapper/one/*.xml";

    @Primary
    @Bean(name = "mysqlDataSourceOne")
    @ConfigurationProperties("spring.datasource.druid.mysqlone")
    public DataSource mysqlDataSourceOne() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlTransactionManagerOne")
    @Primary
    public DataSourceTransactionManager mysqlTransactionManagerOne() {
        return new DataSourceTransactionManager(mysqlDataSourceOne());
    }

    @Bean(name = "mysqlSqlSessionFactoryOne")
    @Primary
    public SqlSessionFactory mysqlSqlSessionFactoryOne(@Qualifier("mysqlDataSourceOne") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MysqlDatasourceOneConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
