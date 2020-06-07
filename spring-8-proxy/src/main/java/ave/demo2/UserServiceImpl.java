package ave.demo2;

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
