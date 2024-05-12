package com.lee.springbootworkspaceblogger.sql.repository;

import com.lee.springbootworkspaceblogger.sql.BasicRepository;
import com.lee.springbootworkspaceblogger.sql.entity.Boards;
import com.lee.springbootworkspaceblogger.sql.entity.ForumInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BoardsRepository extends BasicRepository<Boards, Integer> {
    //點擊文章計數
    @Modifying
    @Query(" update Boards f set  f.pagecount =?1 where f =?2 ")
    void updateForumInfoByPageCount(@Param("pagecount")  int pagecount , @Param("id") Boards boards)throws Exception;

    //回復計數
    @Modifying
    @Query(" update Boards f set  f.replycoun =?1 where f =?2 ")
    void updateForumInfoByReplyCount(@Param("replyCount")  int replyCount , @Param("id") Boards boards)throws Exception;
}
