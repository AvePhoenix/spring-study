import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;
import pojo.User;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Student student = (Student)context.getBean("student");
        System.out.println(student.toString());

    }
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
//        User user = (User) context.getBean("user");
        User user = context.getBean("user1", User.class);
        System.out.println(user.toString());
    }
}
