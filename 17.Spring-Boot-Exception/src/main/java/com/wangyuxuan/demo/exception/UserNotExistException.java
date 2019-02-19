package com.wangyuxuan.demo.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/19 10:06
 * @Description:
 */

@Getter
@Setter
public class UserNotExistException extends RuntimeException{
    private static final long serialVersionUID = 2246310101888348810L;

    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }
}
