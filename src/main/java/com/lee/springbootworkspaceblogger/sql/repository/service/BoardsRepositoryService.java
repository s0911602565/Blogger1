package com.lee.springbootworkspaceblogger.sql.repository.service;

import com.lee.springbootworkspaceblogger.sql.entity.Boards;

public interface BoardsRepositoryService {
    void updateBoardsRepositoryServicePageCount(int pageCount ,Boards boards)throws Exception;

    void updateBoardsRepositoryServiceReplyCount(int replyCount , Boards boards )throws Exception;


}
