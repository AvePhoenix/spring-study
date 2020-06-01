import org.springframework.context.support.ClassPathXmlApplicationContext;
import ave.pojo.User;

public class Mytext {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.name);


    }
}
