package com.lee.springbootworkspaceblogger.sql.repository;

import com.lee.springbootworkspaceblogger.sql.BasicRepository;
import com.lee.springbootworkspaceblogger.sql.entity.Boards;
import com.lee.springbootworkspaceblogger.sql.entity.ForumInfo;
import com.lee.springbootworkspaceblogger.sql.entity.Reply;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ForumInfoRepository extends BasicRepository<ForumInfo, Integer> {
    @Query(" from ForumInfo where account=?1 and password=?2 ")
    Optional<ForumInfo> findUser(String account, String password)throws Exception;
}
