package aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Component
@Aspect
public class ExceptionHandlerAspect {

    //* return type
    //.. no matter how deep (packages)
    //* - nameof the class
    //.* - method name I don't care
    //(..) don't care about params
    @Pointcut("execution(* aop..*Service*.*(..))")
    public void allServicesMethods(){}

    @AfterThrowing(pointcut = "allServicesMethods()",throwing = "ex")
    public void handleDBExceptions(DBException ex) {
        System.out.println(ex.getMessage());
    }


}
