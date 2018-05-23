package com.ray.dao;

import com.ray.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    /**
     * 按书名查询
     */
    List<Book> selectBookByName(@Param("bookName") String bookName);

    /**
     * 借书
     */
    void borrow(@Param("id") Long id, @Param("borrow_person") String userName);

    /**
     * 按借书人查询
     */
    List<Book> selectBookByBorrowPerson(@Param("borrow_person") String PersonName);

    /**
     * 还书
     */
    void returnBook(@Param("id") Long id);
}