package com.lee.springbootworkspaceblogger.controller;

import com.lee.springbootworkspaceblogger.sql.entity.Boards;
import com.lee.springbootworkspaceblogger.sql.entity.Category;
import com.lee.springbootworkspaceblogger.sql.entity.ForumInfo;
import com.lee.springbootworkspaceblogger.sql.repository.BoardsRepository;
import com.lee.springbootworkspaceblogger.sql.repository.CategoryRepository;
import com.lee.springbootworkspaceblogger.sql.repository.ForumInfoRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Api(tags = "建立版主")
@Controller
@RequestMapping("createBorder")
public class CreateBorder {
    @Autowired CategoryRepository categoryRepository;
    @Autowired BoardsRepository boardsRepository;
    @Autowired ForumInfoRepository forumInfoRepository;

    @RequestMapping
    public String userData(
            @Param("categoryID") String categoryID,//項目ID
            @Param("titleName") String titleName,//標題
            @Param("description") String description,//描述
            HttpServletRequest request) throws Exception{
        int userID = Integer.parseInt(request.getSession().getAttribute("userID").toString());
        Category category = null;
        ForumInfo forumInfo = null;
        Optional<Category>  optionalCategory = categoryRepository.findById(Integer.parseInt(categoryID));
        Optional<ForumInfo>  optionalForumInfo =  forumInfoRepository.findById(userID);

        if(optionalCategory.isPresent()) category = optionalCategory.get();
        if(optionalForumInfo.isPresent()) forumInfo = optionalForumInfo.get();

        Boards boards = new Boards();//部落格
        boards.setBoardsname(titleName);
        boards.setDescription(description);
        boards.setCategory(category);//項目
        boards.getForumInfo().add(forumInfo);
        boardsRepository.save(boards);

        return "/login";
    }
}
