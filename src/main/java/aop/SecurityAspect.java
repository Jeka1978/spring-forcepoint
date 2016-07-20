package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Component
@Aspect
public class SecurityAspect {

    @Around("@annotation(Secured)")
    public Object doSecured(ProceedingJoinPoint pjp) throws Throwable {
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            return pjp.proceed();
        }else {
            throw new RuntimeException("not allowed here, try again");
        }
    }
}
