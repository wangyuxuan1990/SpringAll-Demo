package com.wangyuxuan.demo.service;


import com.wangyuxuan.demo.domain.User;

public interface UserService extends IService<User>{
	User findByName(String userName);
	
	void saveUser(User user);
}
