package com.lee.springbootworkspaceblogger.controller;

import com.lee.springbootworkspaceblogger.sql.entity.Category;
import com.lee.springbootworkspaceblogger.sql.entity.ForumInfo;
import com.lee.springbootworkspaceblogger.sql.repository.CategoryRepository;
import com.lee.springbootworkspaceblogger.sql.repository.ForumInfoRepository;
import com.lee.springbootworkspaceblogger.sql.repository.service.IMailService;
import com.lee.springbootworkspaceblogger.util.util.Common;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Api(tags = "註冊")
@Controller
@RequestMapping("signUpExecute")
public class SignUpExecute {
    private final IMailService iMailService;
    private final CategoryRepository categoryRepository;
    private final ForumInfoRepository forumInfoRepository;

    public SignUpExecute(IMailService iMailService, CategoryRepository categoryRepository, ForumInfoRepository forumInfoRepository) {
        this.iMailService = iMailService;
        this.categoryRepository = categoryRepository;
        this.forumInfoRepository = forumInfoRepository;
    }

    @ApiOperation("註冊")
    @RequestMapping
    public ModelAndView userData(
            @Valid @ModelAttribute ForumInfo forumInfo,
            BindingResult r,
            ModelAndView model,
            HttpServletRequest request

    ) {
        if (r.hasErrors()) {
            List<FieldError> fieldErrors = r.getFieldErrors();
            StringBuilder sb = new StringBuilder();
            fieldErrors.forEach(x -> {
                System.out.println(x.getField() + "/" + x.getDefaultMessage());
                sb.append(x.getField() + "/" + x.getDefaultMessage()).append("</br>");
            });
            model.addObject("msg", sb.toString());
            model.setViewName("signUp");
            return model;
        }
        int age = Common.age(forumInfo.getBirthday());
        forumInfo.setAge(age);
        forumInfoRepository.save(forumInfo);
        request.getSession().setAttribute("user", forumInfo.getUser());
        request.getSession().setAttribute("userID", forumInfo.getId());
        //iMailService.sendEmail("s098002040@gmail.com", "註冊通知", "恭喜您註冊部落格");


        model.setViewName("redirect:/signUpExecute/createInfo");
        return model;

    }

    @ApiOperation("開新版頁")
    @RequestMapping("createInfo")
    public ModelAndView createInfo(ModelAndView model){
        List<Category> listCategory = categoryRepository.findAll();
        model.addObject("listCategory", listCategory);
        model.setViewName("/createCategory");
        return model;
    }
}
