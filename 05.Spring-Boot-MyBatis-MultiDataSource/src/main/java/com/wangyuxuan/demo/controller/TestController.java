package com.wangyuxuan.demo.controller;

import com.wangyuxuan.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/1 10:49
 * @Description:
 */

@RestController
public class TestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("queryStudentsFromOne")
    public List<Map<String, Object>> queryStudentsFromOne(){
        return this.studentService.getAllStudentsFromOne();
    }

    @RequestMapping("queryStudentsFromTwo")
    public List<Map<String, Object>> queryStudentsFromTwo(){
        return this.studentService.getAllStudentsFromTwo();
    }

}
