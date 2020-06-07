package ave.demo2;

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
