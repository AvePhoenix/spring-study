package ave.log;

import ave.service.UserServiceImpl;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.reflect.Method;
@Configurable
@ComponentScan("ave.log")
@Import(UserServiceImpl.class)
public class Log implements MethodBeforeAdvice {
    //method  要执行的目标对象的方法，
    //atgs  参数
    //target  目标对象
    public void before(Method method, Object[] atgs, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"的"+method.getName()+"被执行了");//什么类的什么方法
    }
}
