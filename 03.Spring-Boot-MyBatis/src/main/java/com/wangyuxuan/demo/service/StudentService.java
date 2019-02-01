package com.wangyuxuan.demo.service;

import com.wangyuxuan.demo.bean.Student;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/1 10:43
 * @Description:
 */
public interface StudentService {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    Student queryStudentBySno(String sno);
}
