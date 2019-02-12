package com.wangyuxuan.demo.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/11 16:47
 * @Description:
 */

@Data
public class SysLog implements Serializable {

    private static final long serialVersionUID = 8028751035959396515L;

    private Integer id;
    private String username;
    private String operation;
    private Integer time;
    private String method;
    private String params;
    private String ip;
    private Date createTime;
}
