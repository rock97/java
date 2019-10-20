package rock.lambda;


public class User {
    private String name;
    private int age;
    public User(String name,int age){
        this.age = age;
        this.name = name;
    }

    public User(){}

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public  String toString(){
        return "{name="+name+",age="+age+"}";
    }
}



