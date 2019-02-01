package com.wangyuxuan.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/1 10:22
 * @Description:
 */

@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 7794301964600712607L;

    private String sno;
    private String name;
    private String sex;
}
