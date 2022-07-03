package Exercise3;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private  int age;
    private String name;
    private String position;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {

        if(position.equals("manager")||position.equals("welder")||position.equals("carpenter")||position.equals("plumber")){
        this.position = position;
        } else{
            System.out.println("Only valid positions are : \"manager\", \"welder\", \"carpenter\" and \"plumber\"");
        }
    }

//    public Person(int age, String name, String position) {
//        age=this.age;
//        name=this.name;
//        position=this.position;
//    }
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}