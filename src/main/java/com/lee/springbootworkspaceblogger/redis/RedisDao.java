package com.lee.springbootworkspaceblogger.redis;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;

@Repository
public class RedisDao {
    @Autowired RedisTemplate redisTemplate;

    public static final String KEY1 = "Writings";
    public static final String KEY2 = "UserInfo";
    public Writings saveWritings(Writings obj){
        redisTemplate.opsForHash().put(KEY1 , obj.getId() , obj);
        return obj;
    }

    public UserInfo saveUserInfo(UserInfo obj){
        redisTemplate.opsForHash().put(KEY2 , obj.getId() , obj);
        return obj;
    }

    public List<Writings> findAllByWritingsList(){
        return redisTemplate.opsForHash().values(KEY1);
    }

    public Map<Object,Writings> findAllByWritingsMap(){
        return redisTemplate.opsForHash().entries(KEY1);
    }

    public List<UserInfo> findAllByUserInfoList(){
        return redisTemplate.opsForHash().values(KEY2);
    }

    public Map<Object,UserInfo> findAllByUserInfoMap(){
        return redisTemplate.opsForHash().entries(KEY2);
    }
}
