import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Hello;

public class MyTest {
    public static void main(String[] args) {

        //获取spring的上下文对象;

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

//        我们的对象都在spring中管理类，我们要使用，直接从里面取出来就好了

        Hello hello = (Hello)context.getBean("hello");
        System.out.println(hello.toString());



    }
}
