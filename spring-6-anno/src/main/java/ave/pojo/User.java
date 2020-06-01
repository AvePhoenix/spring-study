package ave.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sun.misc.Contended;
//等价于    <bean id="user" class="pojo.User"/>
//@Component 组件
@Component
@Scope("prototype")/*作用域  里面有value值和scopeName值
           @Scope("singleton"): 单例
            @Scope("prototype")：原型
            */

public class User {
    @Value("张")//相当于        <property name="name" value="张"/>(一般用于简单的，复杂的还是用配置文件)，可以在属性上，也可以在set上
    public String name;
    @Value("张")//相当于        <property name="name" value="张"/>(一般用于简单的，复杂的还是用配置文件)，可以在属性上，也可以在set上
    public void setName(String name) {
        this.name = name;
    }
}
