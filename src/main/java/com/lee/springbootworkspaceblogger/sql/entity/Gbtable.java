package com.lee.springbootworkspaceblogger.sql.entity;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Gbtable implements java.io.Serializable{
    @Id
    private int bid;
    @Id
    private int gid;
}
