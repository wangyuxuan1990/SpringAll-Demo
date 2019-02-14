package com.wangyuxuan.demo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/14 15:06
 * @Description:
 */

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 6815457792567076600L;

    private Long id;
    private String name;
    private Integer age;
}
