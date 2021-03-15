package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.LogsRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Arrays;

@Aspect
@Component
public class Watcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);
    @Autowired
    private LogsRepository repository;

    @Before("execution(* com.kodilla.ecommercee.controller.*Controller.*(..)) && target(object)")
    public void logEvent(JoinPoint joinPoint, Object object) {
        String info = "Class name: " + object.getClass().getName().substring(34)
                + " Method name: " + joinPoint.getSignature().getName();
        LOGGER.info(info);
        repository.save(new Logs(new Timestamp(System.currentTimeMillis()),info));
         }
    }

