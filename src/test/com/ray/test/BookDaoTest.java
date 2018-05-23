package com.ray.test;

import com.ray.dao.BookMapper;
import com.ray.entity.Book;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ray
 * @date 2018/5/22 0022
 */
public class BookDaoTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void queryById(){
        Book book = bookMapper.selectByPrimaryKey((long) 2);
        System.out.println(book);
    }
}
