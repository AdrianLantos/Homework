package Exercise2and3;

import java.time.LocalDate;

public class DatabaseAdmin extends Employee{

    private String dbTechnology;

    public String getAddress(){
        return "db admin: " + DatabaseAdmin.address;
    }

    public DatabaseAdmin(String firstName, String lastName, LocalDate birthday, String address, LocalDate dateOfEmployment, String dbTechnology) {
        super(firstName, lastName, birthday, address, dateOfEmployment, "Database Admin");
        this.dbTechnology = dbTechnology;
    }
}
