package com.lee.springbootworkspaceblogger.controller;

import com.lee.springbootworkspaceblogger.sql.entity.Boards;
import com.lee.springbootworkspaceblogger.sql.entity.Reply;
import com.lee.springbootworkspaceblogger.sql.repository.BoardsRepository;
import com.lee.springbootworkspaceblogger.sql.repository.ReplyRepository;
import com.lee.springbootworkspaceblogger.sql.repository.service.BoardsRepositoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Api(tags = "顯示各項目的文章")
@Controller
@RequestMapping("showArticle")
public class ShowArticle {
    @Autowired BoardsRepository boardsRepository;
    @Autowired BoardsRepositoryService boardsRepositoryService;
    @Autowired ReplyRepository replyRepository;

    @RequestMapping
    public ModelAndView doArticle(
            @Param("boardsId") String boardsId,
            ModelAndView model
    )throws Exception{
        Optional<Boards> optional =  boardsRepository.findById(Integer.parseInt(boardsId));
        if(optional.isPresent()){
            Boards boards = optional.get();

            int count = boards.getPagecount()+1;
            boardsRepositoryService.updateBoardsRepositoryServicePageCount(count ,boards);//前端被點擊的人氣

            List<Reply> listrep = replyRepository.findReply(boards);
            model.addObject("boards" , boards);
            model.addObject("listrep" , listrep);
        }
        model.setViewName("/showArticle");
        return model;
    }

}
