package com.lee.springbootworkspaceblogger.controller;

import com.lee.springbootworkspaceblogger.sql.entity.Boards;
import com.lee.springbootworkspaceblogger.sql.entity.Category;
import com.lee.springbootworkspaceblogger.sql.entity.ForumInfo;
import com.lee.springbootworkspaceblogger.sql.entity.Reply;
import com.lee.springbootworkspaceblogger.sql.repository.BoardsRepository;
import com.lee.springbootworkspaceblogger.sql.repository.CategoryRepository;
import com.lee.springbootworkspaceblogger.sql.repository.ForumInfoRepository;
import com.lee.springbootworkspaceblogger.sql.repository.service.BoardsRepositoryService;
import com.lee.springbootworkspaceblogger.sql.repository.service.imp.BoardsRepositoryServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Api(tags = "導向回復文章頁面")
@Controller
@RequestMapping("replyBoard")
public class ReplyBoard {
    @Autowired BoardsRepository boardsRepository;
    @Autowired CategoryRepository categoryRepository;
    @Autowired ForumInfoRepository forumInfoRepository;

    @RequestMapping
    public ModelAndView doArticle(
            @Param("boardsId") String boardsId,
            ModelAndView model ,
            HttpServletRequest request
    )throws Exception{
        Optional<Boards> optionalBoards =  boardsRepository.findById(Integer.parseInt(boardsId));
        if(optionalBoards.isPresent()){
            Boards boards = optionalBoards.get();
            Category category = categoryRepository.findById(boards.getCategory().getId()).get();
            String userID = String.valueOf(request.getSession().getAttribute("userID"));
            Optional<ForumInfo> optionalForumInfo = forumInfoRepository.findById(Integer.parseInt(userID));
            if(optionalForumInfo.isPresent()){
                model.addObject("boards" , boards);
                model.addObject("category" , category);
                model.setViewName("/replyView");
            }
        }
        return model;
    }

}
