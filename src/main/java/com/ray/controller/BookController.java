package com.ray.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ray.entity.Book;
import com.ray.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Ray
 * @date 2018/5/23 0023
 */
@Controller
public class BookController {

    @Resource
    private BookService bookService;

    /**
     *  列出所有图书
     */
    @RequestMapping("search")
    @ResponseBody
    public JSONArray searchBook(HttpServletRequest request, HttpServletResponse response){
        String bookName = request.getParameter("bookName");
        System.out.println("search: " + bookName);

        List<Book> books = bookService.selectByName(bookName);

        //创建JSONArray对象
        JSONArray jsonArray = new JSONArray();

        for (Book book : books){
            //创建JSONObject对象
            JSONObject jsonObject = new JSONObject();
            //添加键值对
            jsonObject.put("bookId",book.getId());
            jsonObject.put("bookName",book.getBookName());
            jsonObject.put("bookWriter",book.getBookWriter());
            jsonObject.put("Publisher",book.getBookPublisher());
            jsonObject.put("isrent",book.getBookIsrent());
            jsonArray.add(jsonObject);
        }
        HttpSession session = request.getSession();
        session.setAttribute("searchResult",jsonArray);
        System.out.println("jsonArray: " + jsonArray.toString());

        return jsonArray;
    }

    /**
     *  借阅图书
     */
    @RequestMapping("borrowBook")
    @ResponseBody
    public boolean borrow(HttpServletRequest request, HttpServletResponse response){
        Long id = new Long(request.getParameter("id"));
        System.out.println("request id: " + id);

        Object user = request.getSession().getAttribute("username");
        bookService.borrow(id, user.toString());
        return true;
    }

    /**
     *  显示借阅的图书
     */
    @RequestMapping("showBorrow")
    @ResponseBody
    public JSONArray showBorrow(HttpServletRequest request, HttpServletResponse response){
        Object user = request.getSession().getAttribute("username");
        List<Book> books = bookService.selectBookByBorrowPerson(user.toString());

        JSONArray jsonArray = new JSONArray();
        for(Book book : books){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("bookId",book.getId());
            jsonObject.put("bookName",book.getBookName());
            jsonObject.put("bookWriter",book.getBookWriter());
            jsonObject.put("Publisher",book.getBookPublisher());
            jsonObject.put("isrent",book.getBookIsrent());
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray.toString());
        return jsonArray;
    }

    /**
     *  还书
     */
    @RequestMapping("returnBook")
    @ResponseBody
    public boolean returnBook(HttpServletRequest request, HttpServletResponse response){
        Long id = new Long(request.getParameter("id"));
        bookService.returnBook(id);
        return true;
    }
}
