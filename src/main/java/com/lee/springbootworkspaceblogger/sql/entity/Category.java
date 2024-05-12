package com.lee.springbootworkspaceblogger.sql.entity;


import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Boards> boards = new ArrayList<>();
}

