spring下载：https://repo.spring.io/release/org/springframework/spring/
github：https://github.com/spring-projects



meven:
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>

优点：
	开源的免费的框架（容器）
	轻量级，非入侵式的框架
	控制反转（IOC），面向切面编程（AOP）
	支持事物的处理，对框架的整合支持



spring七大模块：

![image-20200517085200943](C:\Users\AVE\AppData\Roaming\Typora\typora-user-images\image-20200517085200943.png)



学习路线（现代化的java开发）

![image-20200517085257870](C:\Users\AVE\AppData\Roaming\Typora\typora-user-images\image-20200517085257870.png)







springboot

​	一个快速开发的脚手架

​    约束大于配置

spring cloud

​	基于springboot实现，（协调）





IOC理论推导

​	UserDao——>UserDaoImpl——>UserService——>UserServiceImpl



以前业务用户的需求可能会影响原来的代码，我们就需要更具用户的需求修改代码，如果代码量十分大，修改一次的成本代价十分昂贵



我们用Set接口实现（注入）

```
public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
}
```

之前程序是主动创建对象，控制权在程序员手里，使用了set注入之后，程序不在主动创建对象，而是变成了被动的去接受





这总思想程序员不用再去管理对象的创建，（控制反转）。系统的耦合性降低，可以专注的在业务层当中，这就是IOC的原型



IOC的本质

​	控制反转，一种设计思想，，DI（依赖注入），是实现IOC的一种方法，没有IOC的程序中，我们面向对象编程时，对象间的依赖关系完全硬编码在程序中，对象的创建有程序自己控制，控制反转之后将对象的创建转移给第三方，

​	控制反转：获得依赖的方式反转了



采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两种方式合为一体，Bean的定义信息直接以注解的方式定义在实现类中，从而达到0配置的问题



​	控制反转是一种通过描述（XML和注解）并通过通过第三方去生产或获取的特定对象的方式，。在spring中实现控制反转的事IOC容器，实现方法是依赖注入，





IOC创建对象的方式

​	

```
<!--
         无参构造
        <property name="name" value="zhang"/>
    -->

<!--有参构造-->
    <!--  1.    下标赋值
        <constructor-arg index="0" value="qing"/>
    -->
    <!--  2.    通过类型创建*********不建议使用
         <constructor-arg type="java.lang.String" value="lin"/>
    -->
    <!--  3.    直接通过参数名
    <constructor-arg name="name" value="张庆林"/>
    -->
```





总结：在配置文件加载的时候，容器中管理的对象就已经初始化了









spring配置：

​	别名：

```
<alias name="user" alias="askId"/>
```



​	bean的配置：

```
<!--若果添加了别名，也可以用别名-->

<!--
    id;bean的唯一标识符，也就是相当于对象名

    class:bean对象所对应的权限名：包名加类名

    name：别名，可以通时取多个别名，并且等级更高
          ****  <bean id="user1" class="pojo.User1" name="user2">
-->
```



​	import

一般用于团队开发，可以将多个配置文件，

```
<import resource="beans.xml"/>
<import resource="beans1.xml"/>
<import resource="beans2.xml"/>
```





DI依赖注入

​	1.构造器注入

​	2.set注入【重点】

​		依赖注入：set注入

​		依赖：bean对象的创建依赖于容器

​		注入：bean对象中的所有属性由荣起来注入

​           

```
<bean id="address" class="pojo.Address">
    <property name="address" value="西安"/>
</bean>

<bean id="student" class="pojo.Student">

    <!--第一种直接注入  value-->
    <property name="name" value="zhang"/>

    <!--第二种直接注入  ref-->
    <property name="address" ref="address"/>

    <!--数组-->
    <property name="books">
        <array>
            <value>红楼梦</value>
            <value>精瓶梅</value>
            <value>三国演义</value>
            <value>西厢记</value>
        </array>
    </property>

    <!--List-->
    <property name="hobby">
        <array>
            <value>打球</value>
            <value>看书</value>
            <value>听歌</value>
            <value>运动</value>
        </array>
    </property>

    <!--map-->
    <property name="card">
        <map>
            <entry key="身份证" value="123123123123123123"/>
            <entry key="银行卡" value="1231123145644564564"/>
        </map>
    </property>

    <!--set-->
    <property name="game">
        <set>
            <value>LOL</value>
            <value>COC</value>
            <value>BOB</value>
        </set>
    </property>

    <!--null-->
    <property name="wife">
        <null/>
    </property>

    <!--Properties 特殊-->
    <property name="info">
        <props>
            <prop key="学号">201720180701</prop>
            <prop key="性别">男</prop>
            <prop key="姓名">柳阿文</prop>
        </props>
    </property>
</bean>
```



​	3.扩展注入（）

​	p命名空间；

![image-20200517183104994](C:\Users\AVE\AppData\Roaming\Typora\typora-user-images\image-20200517183104994.png)

c命名空间

![image-20200517184128982](C:\Users\AVE\AppData\Roaming\Typora\typora-user-images\image-20200517184128982.png)

注意点：

​	p命名和c命名空间不能直接使用，需要导入约束；

```
xmlns:p="http://www.springframework.org/schema/p"
xmlns:c="http://www.springframework.org/schema/c
```



### 7.4 使用注解实现自动装配（重点）

​	jdk1.5支持的注解，spring2.5就支持了

​	使用注解须知：

* 倒入约束
* 配置注解的支持：

```java
    <?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xmlns:context="http://www.springframework.org/schema/context"//使用注解的约束
   xsi:schemaLocation="http://www.springframework.org/schema/beans
    https://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context//使用注解的约束
    https://www.springframework.org/schema/context/spring-context.xsd">//使用注解的约束

        <!--开启注解支持-->
        <context:annotation-config/>
        </beans>
```
### @Autowired

beans中：

``` java
<bean id="cat" class="pojo.Cat"/>
    <bean id="dog" class="pojo.Dog"/>
    <bean id="people" class="pojo.People" />
    <!--    byName
        会自动在容器上下文查找和自己对象set方法后面的值对应的beanid    名字要唯一
            bytype
        会自动在容器上下文查找和自己对象属性类型相同的beanid     类型只能有一个，若果有两个dog那么就会报错
    -->

    <!--
        在这几条命令中， <bean id="people" class="pojo.People" autowire="byName">
        创建对象通过byname更具people中的set方法进行查找，如果bean上面有
        people中的对应的set函数（id=set）
        如果有cat就进行装配；
        若当dog变为dog111（  <bean id="dog" class="pojo.Dog"/>  ————————><bean id="dog111" class="pojo.Dog"/>）
        那么setdog将不被执行
    -->
<!--
    <bean id="people" class="pojo.People" autowire="byName">
-->
<!--
    <bean id="people" class="pojo.People" autowire="byType">
-->


<!--
    <property name="name" value="zhang" ></property>
-->
       <!-- <property name="dog" ref="dog"></property>
        <property name="cat" ref="cat"></property>-->


   <!-- <bean id="cat" class="pojo.Cat"/>
    <bean id="dog" class="pojo.Dog"/>
    <bean id="people" class="pojo.People">
        <property name="name" value="zhang"></property>
        <property name="dog" ref="dog"></property> 
        <property name="cat" ref="cat"></property>
    </bean>

-->
```

在属性上：

![image-20200531175605007](C:\Users\AVE\AppData\Roaming\Typora\typora-user-images\image-20200531175605007.png)

除了属性还可以在set方法上用，

使用@Autowired甚至可以不要set方法，前提是自动装配的属性在ioc（spring）容器中存在并且符合名字Byname

@ 后面可以跟一个参数

```java
public @interface Autowired {
    boolean required() default true;//Autowired默认为true
}


public class People {

    //在people中
    //如果定义了required = false这说明这个对象可以为空（null）
    @Autowired(required = false)
        private Cat cat;
        @Autowired
        private Dog dog;

        private String name;
```



### @Nullable

标记了这个注解表示可以为null

```java
 public void setName(@Nullable String name) {
            this.name = name;
        }
```



### @Qualifier  

 如果@Autowired自动装配的环境比较复杂，自动装配无法通过一个注解【@Autowired】完成的时候，可以使用@Qualifier（value = "***"）去配置@Autowired的使用，指定一个唯一的bean对象注入

```java
@Autowired
@Qualifier(value = "dog11")  //如果有多个对象，自动装配无法实现，那么就需要  @Qualifier来指定实现的值
private Dog dog;
```

![image-20200531182015561](C:\Users\AVE\AppData\Roaming\Typora\typora-user-images\image-20200531182015561.png)

### `@Resource`

`@Resource`同样可以，作用和`@Autowired`差不多，通过@Resource(name = "cat2")尽心多注入

优先选择`@Autowired`注入，而不是`@Resource`
 注入原理：`@Autowired`会先按类型注入，然后按照名称注入，都无法找到唯一的一个实现类则报错。这于`@Resource`相反



### @Component

```
//等价于    <bean id="user" class="pojo.User"/>
//@Component 组件
@Component
public class User {
    public String name="张庆林";

}
```



##### 小结（`@Autowired`和@Resource`）

* 都是用来自动装配的，都可以放在属性字段上
* `@Autowired`通过bytype方式实现，而且必须要求这个对象存在
* `@Resource`默认通过byname实现，如果找不到名字通过bytype实现
* 执行顺序不同，







### 8.使用注解开发

spring4之后要实现注解开发必须导入包

![image-20200531184508859](C:\Users\AVE\AppData\Roaming\Typora\typora-user-images\image-20200531184508859.png)

使用注解需要导入context约束,增加注解的支持

``` java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/beans/spring-aop.xsd">
	

	<!--两种方式-->
	<!--指定要扫描的包，这个包下的注解就会生效-->
    <context:component-scan base-package="pojo"/>
    <!--开启注解支持-->
    <context:annotation-config/>

</beans>
```



1. bean

2. 属性注入

3. ```java
   @Value("张")//相当于        <property name="name" value="张"/>(一般用于简单的，复杂的还是用配置文件)，可以在属性上，也可以在set上
   public String name;
   @Value("张")//相当于        <property name="name" value="张"/>(一般用于简单的，复杂的还是用配置文件)，可以在属性上，也可以在set上
   public void setName(String name) {
       this.name = name;
   }
   ```

4. 衍生注解

   ```
   @Component有及格衍生注解。我们在web开发中会按照mvc三层架构分层 
   * dao --【@Repository】 -组件- 数据访问层标注
   * service --【@Service】 -组件- 业务层标注
   * controller --【@Controller】-组件- 控制层标注
   这四个注解功能都一样，将某个类注册到spring中，装配Bean
   ```

5. 自动装配

   ```
   @Autowired:自动装配，通过类型（bytype）在名字（byname）
    1. @Nullable：标记了这个注解表示可以为null
    2. Qualifier： 指定一个唯一的bean对象注入（不唯一时）
   @Resource:自动装配，名字（byname）在 通过类型（bytype）
   ```

6. 作用域

   ```
   @Scope  作用域  里面有value值和scopeName值
              @Scope("singleton"): 单例
               @Scope("prototype")：原型
              
   ```

   

7. 小结

   * xml更万能，适用于任何场合，维护简单
   * 注解 如果 不是自己的类就不能使用，维护相对复杂

   最佳实践：

   * xml用来管理bean
   * 注解只负责完成属性的注入
   * 在使用的过程中只需要注意一个问题，必须让注解生效就需要开启注解的支持（两个context）

8.使用Java的方式配置spring

​	完全不使用spring的xml 配置，全权交给了java来做

javaconfig  是spring的一个子项目，在spring4之后变成了核心功能

将配置文件编程配置类，

```xml
@Configurable
//也会被spring容易托管，注册到容器中，因为本身就是一个@Component
//代表这是一个配置类，就相当于bean.xml
@ComponentScan("ave")
//扫描，类似bean中的扫描
@Import(AveConfig2.class)
//将两个类合成一个，相当于拼接
public class AveConfig {
    @Bean
    //注册一个bean，就相当于bean标签，
    //这个方法的名字，就相当于bean标签中的id属性，方法的返回值就相当于class属性
    public User getUser(){
        return new User();//返回要注入到bean的对象
    }
}
```

```java
public static void main(String[] args) {
    //如果完全使用了配置类方式去做，我们就只能通过AnnotationConfig上下文来获取容器，通过配置类的class对象加载
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AveConfig.class);
    User getUser = (User) annotationConfigApplicationContext.getBean("getUser");
    System.out.println(getUser.getName());
}
```

这种纯java的配置方式在springboot中随处可见



## 10、 Aop

代理模式（spring底层）：中介，也就是代理角色，spring是一个容器，项目将对象放到spring让其代理，所以代理模式就是spring的底层重点

学习代理模式，是为了

代理模式分分类：

 	1. 静态代理
 	2. 动态代理



##### 静态代理

角色分析：

* 抽象角色：一般使用接口或者抽象类来解决；
* 真实角色：被代理的角色（房东）
* 代理角色：代理真实角色，代理真实角色后，一般会做一些辅助操作（中介）
* 客户：访问代理对象的人（客人）



##### 代理模式的好处

* 可以是真实的角色操作更加纯粹，（房东只出租房子）不用关注一些公共的业务

* 公共也就交给代理角色，实现了业务分工

* 公共业务发生扩展的时候，方便集中管理（中介除了买房子还可以看房子，收费，签合同）

  ![image-20200605185742357](C:\Users\AVE\AppData\Roaming\Typora\typora-user-images\image-20200605185742357.png)

  ![image-20200605185707692](C:\Users\AVE\AppData\Roaming\Typora\typora-user-images\image-20200605185707692.png)

  ![image-20200605185758180](C:\Users\AVE\AppData\Roaming\Typora\typora-user-images\image-20200605185758180.png)

  ![image-20200605185817186](C:\Users\AVE\AppData\Roaming\Typora\typora-user-images\image-20200605185817186.png)



缺点：一个真实角色就有一个代理角色，代码量翻倍开发效率会变低（解决，动态代理）



**分工于扩展**

在不修改原有功能的情况下，将其交给代理，让代理对齐功能经行扩展，（该表原有的代码是大忌）

```java
public class UserServiceImpl implements UserService {
    /*
    * 如果需要现价一个日志。System.out.println("使用了add方法");，就需要在每个方法里都写一个
    * */
    public void add() {
        /*System.out.println("使用了add方法");*/
        System.out.println("增加了一个用户");
    }

    public void delete() {
//        System.out.println("使用了add方法");
        System.out.println("删除了一个用户");

    }

    public void update() {
//        System.out.println("使用了add方法");

        System.out.println("修改了一个用户");

    }

    public void query() {
//        System.out.println("使用了add方法");
        System.out.println("查找了一个用户");
    }
}
```

```java
public class UserServiceProxy implements UserService {

    private UserServiceImpl userServiceImpl;

    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    public void add() {
        log("add");
        userServiceImpl.add();
    }

    public void delete() {
        log("delete");

        userServiceImpl.delete();
    }

    public void update() {
        log("update");

        userServiceImpl.update();
    }

    public void query() {
        log("query");
        userServiceImpl.query();
    }
    //日志方法
    public void log(String msg){
        System.out.println("使用了" + msg + "方法");
    }

}
```



Aop的实现机制，一个项目（dao--->service--->controller---->前端）想要添加一个功能，就在service中添加一个代理。添加功能；



##### 动态代理（通过反射）

简单，快速，直接以java编码形式体现，不需要了解源码

* 动态代理和静态代理角色是一样的（抽象，代理，真实）
* 动态代理是动态生成的，不是我们自己写的
* 动态代理分为两类：基于接口  基于类
  1. 基于接口的动态代理----JDK动态代理【我们使用】
  2. 基于类的动态代理----cglib
  3. java字节码实现javasist

需要了解两个类：proxy（代理）  invocationHandler（处理）

**invocationHandler**

一个接口，在反射包下

```JAVA
ublic class ProxyInvocationHandler implements InvocationHandler {


    //被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }



    //生成得到代理对像
    public Object getProxy() {
         return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        /*
         *        该方法的使用
         *  有三个参数
         *  第一个ClassLoader当前类对象
         *  第二个代理的接口
         *  InvocationHandler，而在这里的就是继承了该接口的ProxyInvocationHandler
         *
         *
         * */
    }

    //处理代理实例，并返回结果
    /*真正生成代理类的是proxy
    * 使用方法是，有了InvocationHandler接口直接去new一个
    * */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //动态代理的机智就是使用反射实现
        log(method.getName());
        Object result = method.invoke(target, args);

        return result;
    }
  /*  public void seeHouse(){
        System.out.println("中介带去看房子");
    }
    public void free(){
        System.out.println("中介收钱");
    }

*/

    public void log(String msg){
        System.out.println("使用了" + msg + "方法");
    }
}
```

```
public class Client {
    public static void main(String[] args) {
        //真是角色
        UserServiceImpl userService = new UserServiceImpl();
        //代理角色
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        /*
        *
        * 1. 代理一个对像
        * */
        proxyInvocationHandler.setTarget(userService);//设置要代理的对象
        //动态生成代理类
        UserService proxy = (UserService) proxyInvocationHandler.getProxy();
        proxy.add();
        proxy.delete();
        proxy.query();
        proxy.update();
    }
}
```

动态代理的优点：

* 可以是真实的角色操作更加纯粹，不用关注一些公共的业务
* 公共也就交给代理角色，实现了业务分工
* 公共业务发生扩展的时候，方便集中管理
* 一个动态类代理的是一个接口，一般就是对应的一类业务
* 一的动态代理类可以代理多个类，只要接口相同，





### Aop



execution()是最常用的切点函数

**整个表达式可以分为五个部分：**

**1、execution(): 表达式主体。**

**2、第一个*号：表示返回类型， *号表示所有的类型。**

**3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。**

**4、第二个*号：表示类名，*号表示所有的类。**

**5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数**

方式一：spring的接口实现【主要是接口实现】

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

<!--注册bean-->
    <bean id="userService" class="ave.service.UserServiceImpl"/>
    <bean id="log" class="ave.log.Log"/>
    <bean id="afterLog" class="ave.log.AfterLog"/>

    <!--配置aop-->
    <!--方式一：-->
    <!--配置aop：需要导入aop的约素-->
    <aop:config>
        <!--
        切入点：需要在那个地方执行我们的方法
        expression表达式 execution（要执行的位置  ，public修饰词   ，返回值  ，类名  ，方法名  ，参数）
        -->
        <aop:pointcut id="pointcut" expression="execution(* ave.service..UserServiceImpl.*(..))"/>
        <!-- * 代表任意的东西，在ave.service..UserServiceImpl类中的所有方法，中任意的参数-->
        <!--在这个切入点中，执行Log，AfterLog方法-->
        <!--执行环绕增强-->
        <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
        <!--将log这个类切入到pointcut中，也就是说将该类的方法添加到UserServiceImpl中-->
        <!--代码固定，可以配置多个切入，将想切入的方法切入-->
        <aop:advisor advice-ref="afterLog" pointcut-ref="pointcut"/>
        

    </aop:config>


</beans>
```

```java
public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理的是接口

        UserService userService = (UserService) context.getBean("userService");

         userService.add();
    }
}
```

第二种方式：使用自定义类实现【主要是切面定义】

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--注册bean-->
    <bean id="userService" class="ave.service.UserServiceImpl"/>
    <bean id="log" class="ave.log.Log"/>
    <bean id="afterLog" class="ave.log.AfterLog"/>
    <!--方式二 自定义类-->
   <bean id="diy" class="ave.diy.DiyPointCut"/>
    <aop:config>
        <!--自定义切面，要引入的类-->
        <aop:aspect ref="diy">
            <!--切入点-->
            <aop:pointcut id="point" expression="execution(* ave.service.UserServiceImpl.*(..))"/>
            <!--通知-->
            <aop:before method="befote" pointcut-ref="point"/>
            <aop:after method="after" pointcut-ref="point"/>

        </aop:aspect>
    </aop:config>

</beans>
```

```java
public class DiyPointCut {
    public void befote(){
        System.out.println("***************方法执行前*******************");
    }
    public void after(){
        System.out.println("***************方法执行后*******************");
    }
}
```





### 注解实现Aop

```java
public class AnnotationPointCut {
    @Before("execution(* ave.service.UserServiceImpl.*(..))")
    public void befote(){
        System.out.println("***************方法执行前*******************");
    }
    @After("execution(* ave.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("***************方法执行后*******************");
    }
    /* 在环绕增强中，我们可以这只一个参数，代表我们要获取处理的切入点 */
    @Around("execution(* ave.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("环绕前");
        Signature signature = joinPoint.getSignature();
        System.out.println(signature);
        Object proceed = joinPoint.proceed();
        System.out.println("***************方法执行环绕*******************");
        System.out.println(proceed);
        System.out.println("环绕后");
    }
}
```

### 整合Mybatis

步骤：

1. 导入jar包
   * junit
   * mybatis
   * mysql数据库
   * spring相关
   * AOP植入
   * Mybatis-spring【整合mybatis和spring】
2. 编写配置文件
3. 测试





### mybatis

1. 编写实体类、

   ```java
   @Data//重
   public class User {
       private int id;
       private String name;
       private String password;
       private int type;
   
   }
   ```

2. 编写核心配置文件

   

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE configuration
           PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-config.dtd">
   <!--configuration核心配置文件-->
   <configuration>
       <!--别名-->
       <typeAliases>
           <package name="ave.pojo"/>
       </typeAliases>
       <!--连接数据库-->
       <environments default="development">
           <environment id="development">
               <transactionManager type="JDBC" />
               <dataSource type="POOLED">
                   <property name="driver" value="com.mysql.jdbc.Driver" />
                   <property name="url" value="jdbc:mysql://localhost:3306/ssms?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8" />
                   <!--添加了编码问题-->
                   <property name="username" value="root" />
                   <property name="password" value="812090" />
               </dataSource>
           </environment>
       </environments>
       <mappers>
           <mapper class="ave.mapper.UserMapper"/>
       </mappers>
   </configuration>
   ```

3. 编写接口

   

   ```java
   public interface UserMapper {
       public List<User> selectUser();
   }
   ```

4. 编写接口对应的.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <!--创建SQL语句-->
   
   <mapper namespace="ave.mapper.UserMapper">
       <select id="selectUser" resultType="user">
           select * from ssms.user;
       </select>
   
   
   </mapper>
   ```

5. 测试

6. ```java
   public class Mytest {
       @Test
       public void test() throws IOException {
           String resource="mybatis-config.xml";/*得到路径*/
           InputStream resourceAsStream = Resources.getResourceAsStream(resource);/*得到该路径下的资源*/
           SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);/*获取SqlSessionFactory实例*/
           /*SqlSessionFactoryMyBatis的关键对象,它是个单个数据库映射关系经过编译后的内存镜像*/
           SqlSession sqlSession = build.openSession(true);/*得到一个执行器传入事务(Transaction)和类型(execType(枚举))*/
           UserMapper mapper = sqlSession.getMapper(UserMapper.class);
           /*通过 SqlSession 的 getMapper 方法来获取一个 Mapper 接口，就可以调用它的方法了。
           因为 XML 文件或者接口注解定义的 SQL 都可以通过“类的全限定名+方法名”查找，
           所以 MyBatis 会启用对应的 SQL 进行运行，并返回结果。*/
           List<User> users = mapper.selectUser();
           for (User user : users) {
               System.out.println(user);
           }
       }
   }
   ```





### mybatis-spring类

**MyBatis-Spring 会帮助你将 MyBatis 代码无缝地整合到 Spring 中**。它将允许 MyBatis 参与到 Spring 的事务管理之中，**创建映射器 mapper 和 `SqlSession` 并注入到 bean 中**，以及将 Mybatis 的异常转换为 Spring 的 `DataAccessException`。最终，**可以做到应用代码不依赖于 MyBatis，Spring 或 MyBatis-Spring。**

1. 编写数据源配置

2. sqlSessionFactory

3. sqlSessionTemplate

   ```xml
    <!--
           DataSource  使用spring的数据源替换Mybatis的配置
           这里使用spring提供的JDBC:org.springframework.jdbc.datasource
       -->
       <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
           <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
           <property name="url" value="jdbc:mysql://localhost:3306/ssms?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8" />
           <property name="username" value="root"/>
           <property name="password" value="812090"/>
   
       </bean>
       <!--SqlSessionFactory-->
   
       <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
           <property name="dataSource" ref="dataSource" />
           <!--绑定mybatis的配置文件-->
           <property name="configLocation" value="classpath:*.xml"/>
           <property name="mapperLocations" value="classpath:ave/mapper/*.xml"/>
       </bean>
       <!--SqlSessionTemplate就是我们使用的SqlSession-->
       <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
           <!--更具源码发现，没有set方法，所以只能使用构造器注入-->
           <constructor-arg index="0" ref="sqlSessionFactory"/>
       </bean>
   
   
       <!--将实现类注入-->
       <bean id="userMapper" class="ave.mapper.UserMapperImpl">
           <property name="sqlSession" ref="sqlSession"/>
       </bean>
   </beans>
   ```

4. 需要给接口添加实现类

   ```
   public class UserMapperImpl implements UserMapper {
       private SqlSessionTemplate sqlSession;
   
   
   
       /*我们所有的操作，都是用sqlSession来执行，在原来，现在都使用sqlSessionTemplate*/
   
       public List<User> selectUser() {
           UserMapper mapper = sqlSession.getMapper(UserMapper.class);
           return mapper.selectUser();
       }
   
       public void setSqlSession(SqlSessionTemplate sqlSession) {
           this.sqlSession = sqlSession;
       }
   }
   ```

5. 将实现类注入spring中

6. 测试

7. ```
     ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
       UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
       for (User user : userMapper.selectUser()) {
           System.out.println(user);
       }
   }
   ```





### 声明式事务

1. 把一组业务当作一个业务来做，要么成功，要么失败
2. 食物非常重要，涉及到数据一致性问题
3. 确保了完整性和一致性



事务的ACID原则

* 原子性
* 一致性
* 各理性
  * 多个业务操作同一个资源，防止数据损坏
* 持久性
  * 食物一旦提交，无论系统发生什么问题，结果都不会被影响，被持久化写到存储七中