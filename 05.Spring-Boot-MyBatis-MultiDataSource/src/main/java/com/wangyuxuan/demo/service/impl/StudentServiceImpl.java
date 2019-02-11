package com.wangyuxuan.demo.service.impl;

import com.wangyuxuan.demo.mysqlonedao.MysqlOneMapper;
import com.wangyuxuan.demo.mysqltwodao.MysqlTwoMapper;
import com.wangyuxuan.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/1 10:45
 * @Description:
 */

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private MysqlOneMapper mysqlOneMapper;
    @Autowired
    private MysqlTwoMapper mysqlTwoMapper;

    @Override
    public List<Map<String, Object>> getAllStudentsFromOne() {
        return this.mysqlOneMapper.getAllStudents();
    }

    @Override
    public List<Map<String, Object>> getAllStudentsFromTwo() {
        return this.mysqlTwoMapper.getAllStudents();
    }
}
