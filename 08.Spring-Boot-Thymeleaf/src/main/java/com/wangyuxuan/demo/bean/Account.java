package com.wangyuxuan.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/12 10:38
 * @Description:
 */

@Data
@AllArgsConstructor
public class Account {

    private String account;
    private String name;
    private String password;
    private String accountType;
    private String tel;
}
