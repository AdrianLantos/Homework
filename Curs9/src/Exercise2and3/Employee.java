package Exercise2and3;

import java.time.LocalDate;

public class Employee implements Person{
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    protected static String address;

    private LocalDate dateOfEmployment;

    private String position;

    public Employee(String firstName, String lastName, LocalDate birthday, String address, LocalDate dateOfEmployment, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.dateOfEmployment = dateOfEmployment;
        this.position = position;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
