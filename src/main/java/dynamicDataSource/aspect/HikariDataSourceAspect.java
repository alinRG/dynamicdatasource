package dynamicDataSource.aspect;

import dynamicDataSource.annotation.HikariCPDataSource;
import dynamicDataSource.config.DynamicContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Processing Dynamic DataSource By Aspect
 */

@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class HikariDataSourceAspect {
    @Pointcut("@annotation(dynamicDataSource.annotation.HikariCPDataSource)" + "|| @within(dynamicDataSource.annotation.HikariCPDataSource)")
    public void hikariDataSourcePointCut() {

    }

    @Around("hikariDataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Class targetClass = point.getTarget().getClass();
        Method method = signature.getMethod();

        HikariCPDataSource targetDataSource = (HikariCPDataSource) targetClass.getAnnotation(HikariCPDataSource.class);
        HikariCPDataSource methodDataSource = method.getAnnotation(HikariCPDataSource.class);

        if (targetDataSource != null || methodDataSource != null){
            String value;
            if (methodDataSource != null) {
                value = methodDataSource.value();
            }else {
                value = targetDataSource.value();
            }
            DynamicContextHolder.push(value);
            log.debug("set datasource is {}",value);
        }

        try {
            return point.proceed();
        } finally {
            DynamicContextHolder.poll();
            log.debug("clean datasource");
        }

    }

}
