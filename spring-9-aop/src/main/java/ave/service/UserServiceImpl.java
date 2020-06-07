package ave.service;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("ave.service")
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("增加了一个用户");
    }

    public void delete() {
        System.out.println("删除了一个用户");

    }

    public void update() {
        System.out.println("修改了一个用户");

    }

    public void select() {
        System.out.println("查找了一个用户");

    }
}
