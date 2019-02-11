package com.wangyuxuan.demo.mysqlonedao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/11 13:48
 * @Description:
 */

@Component
@Mapper
public interface MysqlOneMapper {

    List<Map<String, Object>> getAllStudents();
}
