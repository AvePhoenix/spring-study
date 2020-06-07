package ave.demo3;

public class Client {
    public static void main(String[] args) {
        //真是角色：
        Host host = new Host();

        //代理角色：暂时没有
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        //通过程序要处理的角色来处理我们要电用的接口对象

        proxyInvocationHandler.setRent(host);
        Rent proxy = (Rent) proxyInvocationHandler.getProxy();;//这里的proxy就是动态生成的，并没有些
        proxy.rent();

    }
}
