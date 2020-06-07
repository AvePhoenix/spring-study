package ave.diy;

import ave.service.UserServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//使用注解方式实现AOP
@Aspect//标志其为一个切面
@Configurable
@ComponentScan("ave.log")
@Import(UserServiceImpl.class)
public class AnnotationPointCut {
    @Before("execution(* ave.service.UserServiceImpl.*(..))")
    public void befote(){
        System.out.println("***************方法执行前*******************");
    }
    @After("execution(* ave.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("***************方法执行后*******************");
    }
    /* 在环绕增强中，我们可以这只一个参数，代表我们要获取处理的切入点 */
    @Around("execution(* ave.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("环绕前");
        Signature signature = joinPoint.getSignature();
        System.out.println(signature);
        Object proceed = joinPoint.proceed();
        System.out.println("***************方法执行环绕*******************");
        System.out.println(proceed);
        System.out.println("环绕后");
    }
}
