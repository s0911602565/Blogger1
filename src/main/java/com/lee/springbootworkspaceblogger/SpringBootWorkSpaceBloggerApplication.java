package com.lee.springbootworkspaceblogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
public class SpringBootWorkSpaceBloggerApplication {

    public static void main(String[] args) {
        //SQL 8.4.0
        //mysql -u root -p12345678 mysql
        //create database board;
        //mysql -u root -p12345678 < D:\board.sql
        // http://127.0.0.1:8080/blog/index
        // 點選登入
        //帳:lee 密碼:1

        SpringApplication.run(SpringBootWorkSpaceBloggerApplication.class, args);

    }

}
