package com.lee.springbootworkspaceblogger.sql.repository.service;

public interface IMailService {
    void sendEmail(String to, String subject, String body);
}
