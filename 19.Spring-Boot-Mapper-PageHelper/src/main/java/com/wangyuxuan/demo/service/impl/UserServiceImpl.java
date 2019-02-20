package com.wangyuxuan.demo.service.impl;

import com.wangyuxuan.demo.bean.User;
import com.wangyuxuan.demo.service.UserService;
import org.springframework.stereotype.Repository;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/20 16:35
 * @Description:
 */

@Repository("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

}
