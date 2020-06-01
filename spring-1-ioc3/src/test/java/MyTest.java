import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

public class MyTest {
    public static void main(String[] args) {
//        User user = new User();
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user = (User) context.getBean("user");
        user.show();
    }
}
