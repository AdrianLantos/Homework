package Exercise3;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        company.employ(new Person(26, "Vlad"), "manager");
        company.employ(new Person(54, "Dorel"), "welder");
        company.employ(new Person(24, "Cosmin"), "carpenter");
        company.employ(new Person(25, "Viorel"), "plumber");
        company.employ(new Person(34, "Cosman"), "plumber");

        System.out.println(company.getPerson("Cos"));
        System.out.println(company.getPersons("plumber"));
        System.out.println(company.getPersonsOlder(25));
        System.out.println(company.getManager());
        company.fireByName("Viorel");
        System.out.println(company.toString());
    }
}
