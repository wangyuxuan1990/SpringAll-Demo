package com.wangyuxuan.demo.service;

import com.wangyuxuan.demo.bean.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/1 10:43
 * @Description:
 */

@CacheConfig(cacheNames = "student")
public interface StudentService {

    @CachePut(key = "#p0.sno")
    Student update(Student student);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteStudentBySno(String sno);

    @Cacheable(key = "#p0")
    Student queryStudentBySno(String sno);
}
