package com.lee.springbootworkspaceblogger.sql.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.lee.springbootworkspaceblogger.valid.FieldMatch;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldMatch()
public class ForumInfo implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "帳號不為空")
    @Length(min = 8 ,max = 20,message = "帳號長度8-20")
    private String account;
    @NotBlank(message = "密碼不為空")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\w]{8,20}$",message = "違反密碼政策")
    private String password;
    private String birthday;
    private String user;
    private int age;
    private String email;


    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="gbtable", catalog="board", joinColumns = {
            @JoinColumn(name="gid", nullable=false, updatable=false) }, inverseJoinColumns = {
            @JoinColumn(name="bid", nullable=false, updatable=false) })
    private List<Boards> boardses = new  ArrayList<>();

}
