package com.lee.springbootworkspaceblogger;

import com.lee.springbootworkspaceblogger.sql.entity.Boards;
import com.lee.springbootworkspaceblogger.sql.entity.Category;
import com.lee.springbootworkspaceblogger.sql.repository.CategoryRepository;
import com.lee.springbootworkspaceblogger.sql.repository.ForumInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestConn {
    @Autowired
    CategoryRepository categoryRepository;
    @Test
    public void doTest(){
        Category category = categoryRepository.findById(1).get();
        System.out.println(category.getId());
        List<Boards> boards = category.getBoards();
        System.out.println("size "+boards.size());

    }
}
