package service;

import dao.UserDao;
import dao.UserDaoImpl;
import dao.UserDaoMysqlImpl;

public class UserServiceImpl implements UserService {
//   private UserDao userDao=new UserDaoImpl();
    private UserDao userDao;

<<<<<<< HEAD
    public UserDao  getUserDao() {
=======
    public UserDao getUserDao() {
>>>>>>> 5a8a85629f408fb675f9e7f759fcddab76771a74
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();

    }
}
