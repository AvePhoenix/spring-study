package pojo;

public class User1 {


    private String name;
    public User1(){
        System.out.println("无参构造函数");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("name:"+name);
    }
}
