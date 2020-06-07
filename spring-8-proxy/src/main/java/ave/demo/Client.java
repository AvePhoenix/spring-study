package ave.demo;


import ave.demo2.UserService;
import ave.demo2.UserServiceImpl;
import ave.demo2.UserServiceImpl2;


public class Client {
    public static void main(String[] args) {
        //真是角色
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceImpl2 userService2 = new UserServiceImpl2();
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
