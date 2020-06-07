package ave.log;

import ave.service.UserServiceImpl;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.reflect.Method;
@Configurable
@ComponentScan("ave.log")
@Import(UserServiceImpl.class)
public class AfterLog implements AfterReturningAdvice {
    //ReturningAdvice在执行前没有返回结果，执行后才有所以多了一个返回值的判断
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了"+method.getName()+"返回的结果"+returnValue);//什么类的什么方法

    }
}
