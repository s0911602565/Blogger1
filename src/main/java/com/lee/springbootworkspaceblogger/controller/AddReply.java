package com.lee.springbootworkspaceblogger.controller;

import com.lee.springbootworkspaceblogger.sql.entity.Boards;
import com.lee.springbootworkspaceblogger.sql.entity.ForumInfo;
import com.lee.springbootworkspaceblogger.sql.entity.Reply;
import com.lee.springbootworkspaceblogger.sql.repository.BoardsRepository;
import com.lee.springbootworkspaceblogger.sql.repository.ForumInfoRepository;
import com.lee.springbootworkspaceblogger.sql.repository.ReplyRepository;
import com.lee.springbootworkspaceblogger.sql.repository.service.BoardsRepositoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Api(tags = "紀錄回復文章")
@Controller
@RequestMapping("addReply")
public class AddReply {
    @Autowired BoardsRepository boardsRepository;
    @Autowired BoardsRepositoryService boardsRepositoryService;
    @Autowired ReplyRepository replyRepository;
    @Autowired ForumInfoRepository forumInfoRepository;

    @RequestMapping
    public String userData(
            @Param("boardsId") String boardsId,
            @Param("word") String word,
            HttpServletRequest request) throws Exception{
        String userID = String.valueOf(request.getSession().getAttribute("userID"));

        Optional<Boards> optionalBoards = boardsRepository.findById(Integer.parseInt(boardsId));
        if(optionalBoards.isPresent()){
            ForumInfo forumInfo = forumInfoRepository.findById(Integer.parseInt(userID)).get();
            Boards boards = optionalBoards.get();
            Reply reply = new Reply();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String day = sdf.format(new Date());
            reply.setBoards(boards);
            reply.setForumInfo(forumInfo);
            reply.setTitle(word);
            reply.setDate(day);

            replyRepository.save(reply);
            int replyCount = boards.getReplycoun() +1;//回復+1
            boardsRepositoryService.updateBoardsRepositoryServiceReplyCount(replyCount , boards);
        }
        return "redirect:/loginBorder/loadData";
    }
}
