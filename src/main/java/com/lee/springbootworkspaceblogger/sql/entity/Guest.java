package com.lee.springbootworkspaceblogger.sql.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Guest implements java.io.Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String account;
    private String password;
    private String birthday;
    private String user;
    private int age;
    private String email;

}
