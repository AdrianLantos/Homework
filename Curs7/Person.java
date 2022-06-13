public class Person {
    private int age;
    private String name;
    private boolean married;

    public Person(int age, String name, boolean married){
        this.age = age;
        this.name = name;
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isMarried() {
        return married;
    }
}
