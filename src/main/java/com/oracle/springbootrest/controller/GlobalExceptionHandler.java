package com.oracle.springbootrest.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public R<Object> exception(BindException e){
        logger.error("e => {}", e.getClass().getName());
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<Map<String,String>> list = new ArrayList<>();
        fieldErrors.forEach(fieldError -> {
            Map<String,String> map = new HashMap<>();
            map.put("field",fieldError.getField());
            map.put("message",fieldError.getDefaultMessage());
            list.add(map);
        });
        return R.failed("参数校验失败").setData(list);
    }

}
