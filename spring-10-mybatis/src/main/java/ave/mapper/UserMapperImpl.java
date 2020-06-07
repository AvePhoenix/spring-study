package ave.mapper;

import ave.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

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
