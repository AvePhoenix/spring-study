import ave.service.UserService;
import ave.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        //动态代理的是接口

        UserService userService = (UserService) context.getBean("userService");

         userService.add();
    }
}
