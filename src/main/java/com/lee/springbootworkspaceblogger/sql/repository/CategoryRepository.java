package com.lee.springbootworkspaceblogger.sql.repository;

import com.lee.springbootworkspaceblogger.sql.BasicRepository;
import com.lee.springbootworkspaceblogger.sql.entity.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends BasicRepository<Category, Integer> {
    @Query(" from Category where name=?1 ")
    List getAllCarData2(String name );


}

