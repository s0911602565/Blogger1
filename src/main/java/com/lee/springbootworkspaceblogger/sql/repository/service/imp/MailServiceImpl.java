package com.lee.springbootworkspaceblogger.sql.repository.service.imp;

import com.lee.springbootworkspaceblogger.sql.repository.service.IMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailServiceImpl implements IMailService {

    @Autowired  JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);//發送給
        message.setSubject(subject);//主題
        message.setText(body);//內容
        javaMailSender.send(message);
    }
}
