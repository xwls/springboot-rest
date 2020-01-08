package com.oracle.springbootrest.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.oracle.springbootrest.entity.Book;
import com.oracle.springbootrest.service.BookService;
import com.oracle.springbootrest.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public R<List<Book>> books(){
        List<Book> list = bookService.list();
        return R.ok(list);
    }

//    @GetMapping("/book?bookId=102")
    //使用路径传参
    @GetMapping("/book/{bookId}")
    public R<Book> book(@PathVariable Integer bookId){
        Book book = bookService.getById(bookId);
        return R.ok(book);
    }

    @PostMapping("/book")
    public R<Book> save(Book book){
        boolean save = bookService.save(book);
        return save ? R.ok(book) : R.failed("添加失败");
    }

    @PutMapping("/book")
    public R<Book> update(Book book){
        boolean update = bookService.updateById(book);
        return update ? R.ok(book) : R.failed("修改失败");
    }

    @DeleteMapping("/book/{bookId}")
    public R<String> delete(@PathVariable Integer bookId){
        boolean remove = bookService.removeById(bookId);
        return remove ? R.ok("删除成功") : R.failed("删除失败");
    }

}
