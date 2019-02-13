package com.wangyuxuan.demo.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wangyuxuan.demo.pojo.User;

import java.io.IOException;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/13 14:50
 * @Description:
 */
public class UserSerializer extends JsonSerializer<User> {

    @Override
    public void serialize(User value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("user-name", value.getUserName());
        gen.writeEndObject();
    }
}
