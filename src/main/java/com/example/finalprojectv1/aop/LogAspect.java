package com.example.finalprojectv1.aop;

import com.example.finalprojectv1.model.Book;
import com.example.finalprojectv1.util.CustomResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Slf4j
public class LogAspect {
    @Around("Pointcuts.allGetMethods()")
    public Object around1 (ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Вызвался метод" + joinPoint.getSignature() );
        long start = System.currentTimeMillis();

           Object proceed = joinPoint.proceed();

        Long end = System.currentTimeMillis();

        System.out.println("Метод " + joinPoint.getSignature() + " проработал " + (end-start) + "милисекунд ");

        return proceed;



    }

    @Around("Pointcuts.allAddMethods()")
    public Object around2 (ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Вызвался метод" + joinPoint.getSignature() );
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        Long end = System.currentTimeMillis();

        System.out.println("Метод " + joinPoint.getSignature() + " проработал " + (end-start) + "милисекунд ");

        return proceed;
    }

    @Around("Pointcuts.allDeleteMethods()")
    public Object around3 (ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Вызвался метод" + joinPoint.getSignature() );
//        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

//        Long end = System.currentTimeMillis();
//joinPoint.proceed().getClass().getField("name");
//        System.out.println("Метод " + joinPoint.getSignature() + " проработал " + (end-start) + "милисекунд ");

//        System.out.println("Книга " + joinPoint.proceed().getClass().getField("name") + "успешно удалена!");

        return proceed;
    }


}
