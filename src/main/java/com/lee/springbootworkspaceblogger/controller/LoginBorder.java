package com.lee.springbootworkspaceblogger.controller;

import com.lee.springbootworkspaceblogger.sql.entity.Category;
import com.lee.springbootworkspaceblogger.sql.entity.ForumInfo;
import com.lee.springbootworkspaceblogger.sql.repository.CategoryRepository;
import com.lee.springbootworkspaceblogger.sql.repository.ForumInfoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Api(tags =  "登入")
@Controller
@RequestMapping("loginBorder")
public class LoginBorder {
    @Autowired  ForumInfoRepository forumInfoRepository;
    @Autowired  CategoryRepository categoryRepository;

    @ApiOperation("登入完成載入")
    @RequestMapping
    @SneakyThrows(Exception.class)
    public String loginExecute(
            @Param("account") String account ,
            @Param("password") String password ,
            HttpServletRequest request
            ) {
        Optional<ForumInfo> optional = forumInfoRepository.findUser(account, password);
        if (optional.isPresent()) {
            ForumInfo forumInfo = optional.get();
            request.getSession().setAttribute("user" , forumInfo.getUser());
            request.getSession().setAttribute("userID" , forumInfo.getId());
            return "redirect:/loginBorder/loadData";
        }
        return "index";
    }

    @ApiOperation("顯示每項文章")
    @RequestMapping("loadData")
    protected ModelAndView checklist(ModelAndView model){
        List<Category> categoryList = categoryRepository.findAll();
        model.addObject("blogger" , categoryList);
        model.setViewName("checklist");
        return model;
    }
}
