import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {

    public List<String> allPersonNames(List<Person> list) {
        List<String> nameList = new ArrayList<>();
        list.stream().
                filter(person -> person.firstName() != null)
                .filter(person -> person.lastName() != null)
                .forEach(person -> nameList.add(person.firstName() + " " + person.lastName()));
        return nameList;
    }

    public List<Person> majorList(List<Person> list) {
        return list.stream()
                .filter(person -> person.age() > 18)
                .toList();
    }

    public List<Person> fromOrade(List<Person> list) {
        return list.stream()
                .filter(person -> person.city().equalsIgnoreCase("Oradea"))
                .toList();
    }

    public List<Person> fromOradeaOrCluj(List<Person> list) {
        return list.stream()
                .filter(person -> person.city().equalsIgnoreCase("Oradea") || person.city().equalsIgnoreCase("Cluj"))
                .toList();

    }

    public List<String> capitalLetter(List<Person> list) {
        List<String> result = new ArrayList<>();
        return list.stream()
                .filter(person -> person.firstName() != null)
                .map(person -> person.firstName().toUpperCase())
                .toList();
    }

    public List<String> firstNameFirstLetter(List<Person> list) {
        List<String> nameList = new ArrayList<>();
        return list.stream().
                filter(person -> person.firstName() != null)
                .filter(person -> person.lastName() != null)
                .map(person -> person.firstName() + " " + person.lastName().charAt(0))
                .toList();
    }

    public List<Person> ageRestricted(List<Person> list) {
        return list.stream()
                .filter(person -> person.age < 60 && person.age > 18)
                .toList();

    }

    public List<Person> firstNameWithA(List<Person> list) {
        return list.stream()
                .filter(person -> person.firstName.charAt(0) == 'A')
                .toList();

    }

    public List<String> firstNameUnique(List<Person> list) {
        return list.stream().map(Person::firstName).distinct().toList();
    }

    public List<Person> sortByFirstName(List<Person> list) {
        return list.stream()
                .sorted(Comparator.comparing(Person::firstName))
                .toList();
    }

    public List<Person> sortByLastName(List<Person> list) {
        return list.stream()
                .sorted(Comparator.comparing(Person::lastName))
                .toList();
    }

    public List<Person> sortByFirstNameThenLastThenAge(List<Person> list) {
        return list.stream()
                .sorted(Comparator.comparing(Person::firstName).thenComparing(Person::lastName).thenComparing(Person::age))
                .toList();
    }

    public record Person(String firstName, String lastName, int age, String city) {
    }
}
