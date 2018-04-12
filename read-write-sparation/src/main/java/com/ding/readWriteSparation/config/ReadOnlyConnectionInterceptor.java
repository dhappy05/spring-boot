package com.ding.readWriteSparation.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by ding on 2018/4/12.
 */
@Slf4j
@Aspect
@Component
public class ReadOnlyConnectionInterceptor implements Ordered {

    @Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint,ReadOnlyConnection readOnlyConnection) throws Throwable {
        try {
            log.info("set database connection to read only");
            DbContextHolder.setDbType(DbContextHolder.DbType.SLAVE);
            Object result = proceedingJoinPoint.proceed();
            return result;
        }finally {
            DbContextHolder.clearDbType();
            log.info("restore database connection to default");
        }
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
