package com.budgeting.Backend.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Aspect
@Configuration
@Profile("local")
public class ExpenseServiceAspect {
    private final Logger logger = LoggerFactory.getLogger(ExpenseServiceAspect.class);

    @Before("execution(* com.budgeting.Backend.Service.ExpenseService.addExpense(..))")
    public void before(JoinPoint joinPoint){
        logger.info("Add expense successful");
    }
    @Before("execution(* com.budgeting.Backend.Service.ExpenseService.getAll(..))")
    public void after(JoinPoint joinPoint){
        logger.info("Get all expense successful");
    }
}
