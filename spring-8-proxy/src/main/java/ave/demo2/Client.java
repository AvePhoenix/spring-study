package ave.demo2;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setUserServiceImpl(userServiceImpl);
        userServiceProxy.delete();
    }
}
