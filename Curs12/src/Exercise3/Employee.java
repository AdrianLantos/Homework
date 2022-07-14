package Exercise3;

import Exercise2.Person;

public class Employee extends Person {

    public Employee(String name, Integer age, String hairColour) {
        super(name, age, hairColour);
    }

    private String company;
    private Integer salary;

    public String getCompany() {
        return company;
    }

    public Integer getSalary() {
        return salary;
    }

    public Employee(String name, Integer age, String hairColour, String company, Integer salary) {
        super(name, age, hairColour);
        this.company = company;
        this.salary = salary;
    }


}
