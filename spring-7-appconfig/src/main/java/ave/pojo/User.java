package ave.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component//说明这个类被spring接管，注册到容器中
public class User {
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
    @Value("张庆林")//属性值注入
    public void setName(String name) {
        this.name = name;
    }
}
