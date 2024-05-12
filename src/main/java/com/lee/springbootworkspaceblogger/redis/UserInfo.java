package com.lee.springbootworkspaceblogger.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("UserInfo")
@AllArgsConstructor
public class UserInfo implements Serializable {
    @Id
    private int id;
    private String name;
    private String mail;
}
