package com.lee.springbootworkspaceblogger.util.quartz;

import com.lee.springbootworkspaceblogger.redis.RedisDao;
import com.lee.springbootworkspaceblogger.redis.UserInfo;
import com.lee.springbootworkspaceblogger.redis.Writings;
import com.lee.springbootworkspaceblogger.sql.entity.Boards;
import com.lee.springbootworkspaceblogger.sql.entity.ForumInfo;
import com.lee.springbootworkspaceblogger.sql.repository.BoardsRepository;
import com.lee.springbootworkspaceblogger.sql.repository.ForumInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class QuartzJob implements Job {
    @Autowired BoardsRepository boardsRepository;
    @Autowired ForumInfoRepository forumInfoRepository;
    @Autowired RedisDao redisDao;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<Boards> boardsList =  boardsRepository.findAll();
        List<ForumInfo> forumInfoList =  forumInfoRepository.findAll();
        if(!boardsList.isEmpty()){
            boardsList.forEach(x->{

                Writings writings = new Writings(x.getId() , x.getBoardsname() , x.getDescription());
                redisDao.saveWritings(writings);
            });
        }
        if(!forumInfoList.isEmpty()){
            forumInfoList.forEach(x->{
                UserInfo userInfo = new UserInfo(x.getId() , x.getUser() , x.getEmail());
                redisDao.saveUserInfo(userInfo);
            });
        }

    }
}
