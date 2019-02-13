package com.wangyuxuan.demo.pojo;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wangyuxuan.demo.config.UserDeserializer;
import com.wangyuxuan.demo.config.UserSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: wangyuxuan
 * @Date: 2019/2/13 13:44
 * @Description:
 */

//@JsonDeserialize(using = UserDeserializer.class)
//@JsonSerialize(using = UserSerializer.class)
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
//@JsonIgnoreProperties({"age", "password"})
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 7763070310582158078L;

    public interface UserNameView {
    }

    public interface AllUserFieldView extends UserNameView{
    }

    @JsonView(UserNameView.class)
    private String userName;
    @JsonView(AllUserFieldView.class)
    private int age;
    @JsonView(AllUserFieldView.class)
//    @JsonIgnore
    private String password;
    @JsonView(AllUserFieldView.class)
//    @JsonProperty("bth")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
}
