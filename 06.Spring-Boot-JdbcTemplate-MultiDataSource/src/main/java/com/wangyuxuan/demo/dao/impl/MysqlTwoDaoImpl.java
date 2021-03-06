package com.wangyuxuan.demo.dao.impl;

import com.wangyuxuan.demo.dao.MysqlTwoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/11 15:34
 * @Description:
 */

@Repository
public class MysqlTwoDaoImpl implements MysqlTwoDao {

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getAllStudents() {
        return this.jdbcTemplate.queryForList("select * from student");
    }
}
