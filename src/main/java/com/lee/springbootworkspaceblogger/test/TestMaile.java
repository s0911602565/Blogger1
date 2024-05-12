package com.lee.springbootworkspaceblogger.test;


import com.lee.springbootworkspaceblogger.sql.repository.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestMaile {
    @Autowired IMailService iMailService;
    public void doMail(){
        iMailService.sendEmail("s098002040@gmail.com" , "標題" , "內容");
    }

}
