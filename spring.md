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



