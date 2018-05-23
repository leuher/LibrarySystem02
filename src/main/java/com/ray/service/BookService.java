package com.ray.service;

import com.ray.entity.Book;

import java.util.List;

/**
 * @author Ray
 * @date 2018/5/23 0023
 */
public interface BookService {

    List<Book> selectByName(String bookName);
    Book selectBookById(Long id);
    List<Book> selectBookByBorrowPerson(String PersonName);
    void save(Book book);
    void borrow(Long id,String username);
    void returnBook(Long id);
}
