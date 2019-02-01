package com.wangyuxuan.demo.dao;

import com.wangyuxuan.demo.bean.Student;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/1 14:28
 * @Description:
 */
public interface StudentDao {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    List<Map<String,Object>> queryStudentsListMap();
    Student queryStudentBySno(String sno);
}
