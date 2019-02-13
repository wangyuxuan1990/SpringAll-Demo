package com.wangyuxuan.demo.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.wangyuxuan.demo.pojo.User;

import java.io.IOException;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/13 14:56
 * @Description:
 */
public class UserDeserializer extends JsonDeserializer<User> {

    @Override
    public User deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode jsonNode = p.getCodec().readTree(p);
        String userName = jsonNode.get("user-name").asText();
        User user = new User();
        user.setUserName(userName);
        return user;
    }
}
