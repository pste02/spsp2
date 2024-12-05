package com.example.spsp2;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
@Slf4j
public class MyAspects {

    @AfterReturning(value = "execution(* returnAllPets(..))", returning = "pets")
    public void afterReturningReturnAllPets(JoinPoint joinPoint, Object pets) {
        log.info("Returning from {} with {}", joinPoint.getSignature().getName(),
                pets);
    }

    @After(value = "execution(* returnAllPets(..))")
    public void afterExecutingReturnAllPets(JoinPoint joinPoint) {
        log.info("Finished with {}", joinPoint.getSignature().getName());
    }

    @Before(value = "execution(* com.example.spsp2.services..*.*(..))")
    public void beforeExecutingComExampleSpsp2(JoinPoint joinPoint) {
        log.info("About to execute {} with arguments {}",
                joinPoint.getSignature().getName(),
                joinPoint.getArgs())    ;
    }
}
