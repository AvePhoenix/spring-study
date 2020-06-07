package ave.demo;

import ave.demo3.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
*
* 代理谁，生成代理，调用代理
* */

//用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {


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
