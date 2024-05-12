package com.lee.springbootworkspaceblogger.sql.repository;

import com.lee.springbootworkspaceblogger.sql.BasicRepository;
import com.lee.springbootworkspaceblogger.sql.entity.Boards;
import com.lee.springbootworkspaceblogger.sql.entity.ForumInfo;
import com.lee.springbootworkspaceblogger.sql.entity.Reply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository extends BasicRepository<Reply, Integer> {

    @Query(" from Reply f where f.boards =?1 ")
    List<Reply> findReply(@Param("boards") Boards boards)throws Exception;
}
