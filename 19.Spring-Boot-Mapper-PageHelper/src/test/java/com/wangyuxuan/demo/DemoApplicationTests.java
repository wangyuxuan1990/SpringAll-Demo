package com.wangyuxuan.demo;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyuxuan.demo.bean.User;
import com.wangyuxuan.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
//        User user = new User();
//        user.setUsername("scott");
//        user.setPasswd("ac089b11709f9b9e9980e7c497268dfa");
//        user.setCreateTime(new Date());
//        user.setStatus("0");
//        this.userService.save(user);

//        Example example = new Example(User.class);
//        example.createCriteria().andCondition("username like '%t%'");
//        example.setOrderByClause("id desc");
//        List<User> userList = this.userService.selectByExample(example);
//        for (User user : userList) {
//            System.out.println(user.getUsername());
//        }
//
//        List<User> all = this.userService.selectAll();
//        for (User user : all) {
//            System.out.println(user.getUsername());
//        }
//
//        User user = new User();
//        user.setId(1);
//        user = this.userService.selectByKey(user);
//        System.out.println(user.getUsername());

//        User user = new User();
//        user.setId(3);
//        this.userService.delete(user);

        PageHelper.startPage(2, 2);
        List<User> list = this.userService.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        List<User> result = pageInfo.getList();
        for (User user : result) {
            System.out.println(user.getUsername());
        }
    }

}

