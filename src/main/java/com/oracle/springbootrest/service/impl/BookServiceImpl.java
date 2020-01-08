package com.oracle.springbootrest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oracle.springbootrest.entity.Book;
import com.oracle.springbootrest.mapper.BookMapper;
import com.oracle.springbootrest.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
}
