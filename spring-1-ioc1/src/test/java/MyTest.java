import dao.UserDaoImpl;
import dao.UserDaoMysqlImpl;
import dao.UserDaoOracleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {



        //        获取applicationContext；
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        Object userSeviceImpl = context.getBean("UserSeviceImpl");
        UserServiceImpl userSeviceImpl = (UserServiceImpl) context.getBean("UserSeviceImpl");
        userSeviceImpl.getUser();
    }
}
