package pojo;

public class User {


    private String name;
    public User(String name){
        this.name=name;
        System.out.println("有参构造函数");
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
