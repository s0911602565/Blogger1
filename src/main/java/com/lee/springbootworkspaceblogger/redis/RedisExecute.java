package com.lee.springbootworkspaceblogger.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("redisConnection")
public class RedisExecute {
    @Autowired RedisDao redisDao;

    @RequestMapping("save1")
    public Writings save(@RequestBody Writings obj) {
        redisDao.saveWritings(obj);
        return obj;
    }

    @RequestMapping("save2")
    public UserInfo saveUserInfo(@RequestBody UserInfo obj) {
        redisDao.saveUserInfo(obj);
        return obj;
    }

    @RequestMapping("findAllByWritingsList")
    public List<Writings> findAllByWritingsList(){
        List list = redisDao.findAllByWritingsList();
        for(int i = 0 ; i < list.size() ; i++){
            Writings writings = (Writings)list.get(i);
            System.out.println(writings.getId() + " " + writings.getName() + " " + writings.getTitle());
        }
        return list;
    }

    @RequestMapping("findAllByWritingsMap")
    public Map<Object,Writings> findAllByWritingsMap(){
        Map<Object,Writings> map =  redisDao.findAllByWritingsMap();
        for(Object obj : map.keySet()){
            Writings writings  = map.get(obj);
            System.out.println( writings.getId() + " " + writings.getName() + " " + writings.getTitle());
        }
        return map;
    }

    @RequestMapping("findAllByUserInfoList")
    public List<Writings> findAllByUserInfoList(){
        List list = redisDao.findAllByUserInfoList();
        for(int i = 0 ; i < list.size() ; i++){
            UserInfo userInfo = (UserInfo)list.get(i);
            System.out.println(userInfo.getId() + " " + userInfo.getName() + " " + userInfo.getMail());
        }
        return list;
    }

    //http://127.0.0.1:8080/redisConnection/findAllByWritingsMap
    @RequestMapping("findAllByUserInfoMap")
    public Map<Object,UserInfo> findAllByUserInfoMap(){
        Map<Object,UserInfo> map =  redisDao.findAllByUserInfoMap();
        for(Object obj : map.keySet()){
            UserInfo userInfo  = map.get(obj);
            System.out.println( userInfo.getId() + " " + userInfo.getName() + " " + userInfo.getMail());
        }
        return map;
    }
}
