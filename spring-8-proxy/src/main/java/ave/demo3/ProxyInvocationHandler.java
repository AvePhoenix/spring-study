package ave.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {


    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到代理对像
    public Object getProxy() {
         return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
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
        seeHouse();
        Object result = method.invoke(rent, args);
        free();

        return result;
    }
    public void seeHouse(){
        System.out.println("中介带去看房子");
    }
    public void free(){
        System.out.println("中介收钱");
    }


}
