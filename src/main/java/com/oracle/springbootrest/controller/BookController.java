package com.oracle.springbootrest.controller;

import com.oracle.springbootrest.entity.Book;
import com.oracle.springbootrest.service.BookService;
import com.oracle.springbootrest.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Result<List<Book>> books(){
        List<Book> list = bookService.list();
        Result<List<Book>> result = new Result<>();
        result.setCode(0);
        result.setMsg("操作成功");
        result.setData(list);
        return result;
    }

}
