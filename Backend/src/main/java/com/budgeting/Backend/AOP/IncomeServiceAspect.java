package com.budgeting.Backend.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class IncomeServiceAspect {
    private Logger logger = LoggerFactory.getLogger(IncomeServiceAspect.class);

    @Before("execution(* com.budgeting.Backend.Service.IncomeService.addIncome(..))")
    public void before(JoinPoint joinPoint){
        logger.info("Add income successful");
    }
    @Before("execution(* com.budgeting.Backend.Service.IncomeService.getAll(..))")
    public void after(JoinPoint joinPoint){
        logger.info("Get income successful");
    }
}
