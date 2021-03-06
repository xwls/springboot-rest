package com.oracle.springbootrest.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    //AOP的前置通知，在目标方法执行之前执行
    @Before("execution(public * com.oracle.springbootrest.controller.BookController.*(..))")
    public void before(JoinPoint joinPoint){
        //获取方法名
        String name = joinPoint.getSignature().getName();
        logger.debug("method {} begin.....", name);
        //获取方法参数
        Object[] args = joinPoint.getArgs();
        logger.debug("method args : {}.....", Arrays.toString(args));
        //获取请求方法
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String method = request.getMethod();
        //获取请求地址
        String requestURI = request.getRequestURI();
        logger.debug("{} => {}", method, requestURI);
    }

    //AOP的后置通知，在目标方法执行之后执行
    @After("execution(public * com.oracle.springbootrest.controller.BookController.*(..))")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        logger.debug("method {} end.....", name);
    }

    //返回通知，在目标方法返回内容时执行
    @AfterReturning(pointcut = "execution(public * com.oracle.springbootrest.controller.BookController.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String name = joinPoint.getSignature().getName();
        logger.debug("the method {} return => {}", name, result);
    }

    //异常通知，在目标方法出现异常是执行
    @AfterThrowing(pointcut = "execution(public * com.oracle.springbootrest.controller.BookController.*(..))",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        String name = joinPoint.getSignature().getName();
        logger.debug("the method {} exception => {}",name, e);
    }

}
