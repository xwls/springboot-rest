package com.oracle.springbootrest.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    //AOP的前置通知
    @Before("execution(public * com.oracle.springbootrest.controller.BookController.*(..))")
    public void before(){
        logger.debug("method begin.....");
    }

    //AOP的后置通知
    @After("execution(public * com.oracle.springbootrest.controller.BookController.*(..))")
    public void after(){
        logger.debug("method end.....");
    }

}
