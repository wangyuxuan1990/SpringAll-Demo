package com.wangyuxuan.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangyuxuan.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/13 13:46
 * @Description:
 */

@Controller
public class TestJsonController {

    @Autowired
    private ObjectMapper mapper;

    /**
     * 自定义ObjectMapper
     */
//    @JsonView(User.UserNameView.class)
    @JsonView(User.AllUserFieldView.class)
    @RequestMapping("getUser")
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setUserName("EthanWong");
        user.setBirthday(new Date());
        user.setAge(29);
        user.setPassword("123456");
        return user;
    }

    /**
     * 序列化
     */
    @RequestMapping("serialization")
    @ResponseBody
    public String serialization() {
        try {
            User user = new User();
            user.setUserName("EthanWong");
            user.setBirthday(new Date());
            String str = mapper.writeValueAsString(user);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化 树遍历
     * readTree方法可以接受一个字符串或者字节数组、文件、InputStream等，
     * 返回JsonNode作为根节点，你可以像操作XML DOM那样操作遍历JsonNode以获取数据。
     */
    @RequestMapping("readJsonString")
    @ResponseBody
    public String readJsonString() {
        try {
            String json = "{\"name\":\"EthanWong\",\"age\":29}";
            JsonNode jsonNode = this.mapper.readTree(json);
            String name = jsonNode.get("name").asText();
            int age = jsonNode.get("age").asInt();
            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化 绑定对象
     */
    @RequestMapping("readJsonAsObject")
    @ResponseBody
    public String readJsonAsObject() {
        try {
//            String json = "{\"userName\":\"EthanWong\",\"age\":29}";
//            User user = this.mapper.readValue(json, User.class);
//            String name = user.getUserName();
//            int age = user.getAge();
//            return name + " " + age;
            String json = "{\"user-name\":\"EthanWong\"}";
            User user = this.mapper.readValue(json, User.class);
            String name = user.getUserName();
            return name;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Spring Boot 能自动识别出List对象包含的是User类，
     * 因为在方法中定义的泛型的类型会被保留在字节码中，
     * 所以Spring Boot能识别List包含的泛型类型从而能正确反序列化。
     */
    @RequestMapping("updateUser")
    @ResponseBody
    public int updateUser(@RequestBody List<User> list) {
        return list.size();
    }

    @RequestMapping("customize")
    @ResponseBody
    public String customize() throws IOException {
        String jsonStr = "[{\"userName\":\"EthanWong\",\"age\":29},{\"userName\":\"WangYuXuan\",\"age\":29}]";
        JavaType javaType = this.mapper.getTypeFactory().constructParametricType(List.class, User.class);
        List<User> list = this.mapper.readValue(jsonStr, javaType);
        String msg = "";
        for (User user : list) {
            msg += user.getUserName();
        }
        return msg;
    }
}
