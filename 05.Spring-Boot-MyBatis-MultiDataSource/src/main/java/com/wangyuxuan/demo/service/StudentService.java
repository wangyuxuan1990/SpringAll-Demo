package com.wangyuxuan.demo.service;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/1 10:43
 * @Description:
 */
public interface StudentService {
    List<Map<String, Object>> getAllStudentsFromOne();
    List<Map<String, Object>> getAllStudentsFromTwo();
}
