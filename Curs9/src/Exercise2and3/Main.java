package Exercise2and3;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Adrian", "Lantos", LocalDate.of(1996, Month.APRIL, 1), "Cluj", LocalDate.of(2022, Month.DECEMBER, 1), "Java");
        DatabaseAdmin databaseAdmin = new DatabaseAdmin("Adrian", "Lantos", LocalDate.of(1996, Month.APRIL, 1), "Cluj", LocalDate.of(2022, Month.DECEMBER, 1), "Java");
        System.out.println(ex3(programmer));
        System.out.println("getPosition for programmer: " + programmer.getPosition());
        System.out.println("getAddress for dbAdmin: " + databaseAdmin.getAddress());
    }

    public static String ex3(Employee employee) {
        Period p = Period.between(employee.getBirthday(), LocalDate.now());

        String infoName = "Full Name: " + employee.getFirstName() + " " + employee.getLastName();
        String infoAge = "Age: " + p.getYears();

        return infoName + "\n" + infoAge;
    }
}
