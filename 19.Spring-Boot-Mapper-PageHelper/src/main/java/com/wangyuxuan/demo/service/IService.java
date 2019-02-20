package com.wangyuxuan.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/20 16:27
 * @Description:
 */

@Service
public interface IService<T> {

    List<T> selectAll();

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);
}
