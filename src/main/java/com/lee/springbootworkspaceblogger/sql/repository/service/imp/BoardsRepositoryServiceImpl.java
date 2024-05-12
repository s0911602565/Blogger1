package com.lee.springbootworkspaceblogger.sql.repository.service.imp;

import com.lee.springbootworkspaceblogger.sql.entity.Boards;
import com.lee.springbootworkspaceblogger.sql.repository.BoardsRepository;
import com.lee.springbootworkspaceblogger.sql.repository.service.BoardsRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BoardsRepositoryServiceImpl implements BoardsRepositoryService {

    @Autowired BoardsRepository boardsRepository;

    @Override
    public void updateBoardsRepositoryServicePageCount(int pageCount ,Boards boards) throws Exception {
        boardsRepository.updateForumInfoByPageCount(pageCount,boards);
    }

    @Override
    public void updateBoardsRepositoryServiceReplyCount(int replyCount , Boards boards) throws Exception {
        boardsRepository.updateForumInfoByReplyCount(replyCount,boards);
    }



}
