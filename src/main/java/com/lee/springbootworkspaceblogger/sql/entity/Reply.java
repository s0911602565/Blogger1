package com.lee.springbootworkspaceblogger.sql.entity;



import javax.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Reply implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String date;

    @OneToOne
    @JoinColumn(name = "forumInfoId")
    private ForumInfo forumInfo;

    @ManyToOne
    @JoinColumn(name = "boardsId")
    private Boards boards ;
}
