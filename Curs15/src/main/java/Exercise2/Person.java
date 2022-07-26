package Exercise2;

public class Person {
    private  int id;

    private static int idNr = 0;
    private String name;
    private int age;

    public Person(String name, int age) {
        boolean throwException = name == null;
        if (age <= 0 || age >= 120) {
            throwException = true;
        }

        if (!throwException) {
            this.name = name;
            this.age = age;
            this.id = ++this.idNr;
        } else {
            throw new UncheckedException("Name or Age of the Person are invalid");
        }

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
