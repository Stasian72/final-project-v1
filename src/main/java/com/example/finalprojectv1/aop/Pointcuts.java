package com.example.finalprojectv1.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* com.example.finalprojectv1.service.BookService.get*(..))")
    public void allGetMethods() {}

    @Pointcut("execution(* com.example.finalprojectv1.service.BookService.add*(..))")
    public void allAddMethods() {}

    @Pointcut("execution(* com.example.finalprojectv1.service.BookService.delete*(..))")
    public void allDeleteMethods() {}
}
