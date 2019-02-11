package com.wangyuxuan.demo.mysqltwodao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/11 13:50
 * @Description:
 */

@Component
@Mapper
public interface MysqlTwoMapper {

    List<Map<String, Object>> getAllStudents();
}
