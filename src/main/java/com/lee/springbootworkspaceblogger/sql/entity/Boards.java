package com.lee.springbootworkspaceblogger.sql.entity;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Boards implements java.io.Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String boardsname;
    private int pagecount;
    private int replycoun;
    private String description;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @ManyToMany
    @JoinTable(name = "gbtable", catalog = "board", joinColumns = {
            @JoinColumn(name = "bid")}, inverseJoinColumns = {
            @JoinColumn(name = "gid")})
    private List<ForumInfo> forumInfo = new ArrayList<>();

}
