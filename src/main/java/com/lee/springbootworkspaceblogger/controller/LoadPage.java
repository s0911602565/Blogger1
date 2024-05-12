package com.lee.springbootworkspaceblogger.controller;
import com.lee.springbootworkspaceblogger.sql.entity.ForumInfo;
import com.lee.springbootworkspaceblogger.sql.repository.ForumInfoRepository;
import com.lee.springbootworkspaceblogger.sql.repository.service.IMailService;
import com.lee.springbootworkspaceblogger.util.util.Common;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
@Api(tags =  "URL連結")
@Controller
@RequestMapping("blog")
public class LoadPage {

    @RequestMapping({"/index", "/" })
    public String index(){return "/index";}

    @ApiOperation("登入")
    @RequestMapping("login")
    public String login(){return "login";}

    @ApiOperation("註冊")
    @RequestMapping("signUp")
    public String signUp(){return "signUp";}

    @ApiOperation("登出")
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "logout";
    }






}
