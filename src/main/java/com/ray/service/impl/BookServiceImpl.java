package com.ray.service.impl;

import com.ray.dao.BookMapper;
import com.ray.entity.Book;
import com.ray.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ray
 * @date 2018/5/23 0023
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> selectByName(String bookName) {
        List<Book> books = bookMapper.selectBookByName(bookName);
        return books;
    }

    @Override
    public Book selectBookById(Long id) {
        return null;
    }

    @Override
    public List<Book> selectBookByBorrowPerson(String PersonName) {
        List<Book> books = bookMapper.selectBookByBorrowPerson(PersonName);
        return books;
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void borrow(Long id, String username) {
        bookMapper.borrow(id, username);
    }

    @Override
    public void returnBook(Long id) {
        bookMapper.returnBook(id);
    }
}
