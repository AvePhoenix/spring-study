package ave.config;

import ave.pojo.User;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Configurable
//也会被spring容易托管，注册到容器中，因为本身就是一个@Component
//代表这是一个配置类，就相当于bean.xml
@ComponentScan("ave")
//扫描，类似bean中的扫描
public class AveConfig2 {
    @Bean
    //注册一个bean，就相当于bean标签，
    //这个方法的名字，就相当于bean标签中的id属性，方法的返回值就相当于class属性
    public User getUser(){
        return new User();//返回要注入到bean的对象
    }
}
