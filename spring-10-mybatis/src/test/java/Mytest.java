import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
