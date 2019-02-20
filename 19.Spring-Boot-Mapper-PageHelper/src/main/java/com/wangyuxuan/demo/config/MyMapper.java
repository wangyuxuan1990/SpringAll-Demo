package com.wangyuxuan.demo.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/20 16:03
 * @Description:
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
