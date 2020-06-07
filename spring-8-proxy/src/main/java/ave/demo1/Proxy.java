package ave.demo1;

public class Proxy implements Rent {
    /*中介帮助房东租房子*/
    private Host host;

    public Proxy() {

    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        seeHost();
        frare();
        heTong();
        host.rent();
    }

    //看房
    public void seeHost(){
        System.out.println("中介带你看房");
    }
    public void frare(){
        System.out.println("中介收中介费");
    }
    public void heTong(){
        System.out.println("中介签合同");
    }
}
