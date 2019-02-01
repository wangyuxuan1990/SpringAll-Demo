package com.wangyuxuan.demo.controller;

import com.wangyuxuan.demo.bean.Student;
import com.wangyuxuan.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/1 10:49
 * @Description:
 */

@RestController
public class TestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/querystudent", method = RequestMethod.GET)
    public Student queryStudentBySno(String sno) {
        return this.studentService.queryStudentBySno(sno);
    }
}
