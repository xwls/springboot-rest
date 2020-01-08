package com.oracle.springbootrest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oracle.springbootrest.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper extends BaseMapper<Book> {
}
