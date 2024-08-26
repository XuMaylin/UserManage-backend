package org.example.usermanagebackend.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.util.Date;

@ApiModel(value = "用户实体类", description = "用户信息")
@Data
public class User {
    // 用户id
    private Integer userId;
    // 用户名
    private String userName;
    // 密码
    private String password;
    // 创建时间
    private String createTime;
    // 更新时间
    private String updateTime;

    public void setCreateTime(String time) {
        this.createTime = time;
        this.updateTime = time;
    }
    public void setUpdateTime(String time) {
        this.updateTime = time;
    }
}
