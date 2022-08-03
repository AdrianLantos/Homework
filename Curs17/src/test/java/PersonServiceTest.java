import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PersonServiceTest {
    private List<PersonService.Person> list = List.of(
            new PersonService.Person("Marcel", "Popesci", 44, "Slobozia"),
            new PersonService.Person("Maricica", "Constantinescu", 68, "Cluj"),
            new PersonService.Person("Andreea", "Dorian", 7, "Oradea"),
            new PersonService.Person("David", "Popovici", 17, "Cluj"),
            new PersonService.Person("Marc", "Risot", 19, "Bistrita"),
            new PersonService.Person("Andreea", "Pop", 26, "Oradea")
    );

    @Test
    public void allPersonNamesTest() {
        PersonService personService = new PersonService();
        Assertions.assertThat(List.of("Marcel Popesci", "Maricica Constantinescu", "Andreea Dorian", "David Popovici", "Marc Risot", "Andreea Pop")).isEqualTo(personService.allPersonNames(list));
    }

    @Test
    public void majorListTest() {
        PersonService personService = new PersonService();
        Assertions.assertThat(List.of(list.get(0), list.get(1), list.get(4), list.get(5))).isEqualTo(personService.majorList(list));
    }

    @Test
    public void fromOradeTest() {
        PersonService personService = new PersonService();
        Assertions.assertThat(List.of(list.get(2), list.get(5))).isEqualTo(personService.fromOrade(list));
    }

    @Test
    public void fromOradeaOrClujTest() {
        PersonService personService = new PersonService();
        Assertions.assertThat(List.of(list.get(1), list.get(2), list.get(3), list.get(5))).isEqualTo(personService.fromOradeaOrCluj(list));
    }

    @Test
    public void capitalLetterTest() {
        PersonService personService = new PersonService();
        Assertions.assertThat(List.of("MARCEL", "MARICICA", "ANDREEA", "DAVID", "MARC", "ANDREEA")).isEqualTo(personService.capitalLetter(list));
    }

    @Test
    public void firstNameFirstLetterTest() {
        PersonService personService = new PersonService();
        Assertions.assertThat(List.of("Marcel P", "Maricica C", "Andreea D", "David P", "Marc R", "Andreea P")).isEqualTo(personService.firstNameFirstLetter(list));
    }

    @Test
    public void ageRestrictedTest() {
        PersonService personService = new PersonService();
        Assertions.assertThat(List.of(list.get(0), list.get(4), list.get(5))).isEqualTo(personService.ageRestricted(list));
    }

    @Test
    public void firstNameWithA() {
        PersonService personService = new PersonService();
        Assertions.assertThat(List.of(list.get(2), list.get(5))).isEqualTo(personService.firstNameWithA(list));
    }

    @Test
    public void firstNameUniqueTest() {
        PersonService personService = new PersonService();
        Assertions.assertThat(List.of(list.get(0).firstName(), list.get(1).firstName(),list.get(2).firstName(),list.get(3).firstName(),list.get(4).firstName())).isEqualTo(personService.firstNameUnique(list));
    }

    @Test
    public void sortByFirstNameTest(){
        PersonService personService=new PersonService();
        Assertions.assertThat(List.of(list.get(2),list.get(5),list.get(3),list.get(4),list.get(0),list.get(1))).isEqualTo(personService.sortByFirstName(list));
    }

    @Test
    public void sortByFirstNameThenLastThenAgeTest(){
        PersonService personService=new PersonService();
        Assertions.assertThat(List.of(list.get(2),list.get(5),list.get(3),list.get(4),list.get(0),list.get(1))).isEqualTo(personService.sortByFirstNameThenLastThenAge(list));
    }
    @Test
    public void sortByLastNameTest(){
        PersonService personService=new PersonService();
        Assertions.assertThat(List.of(list.get(1),list.get(2),list.get(5),list.get(0),list.get(3),list.get(4))).isEqualTo(personService.sortByLastName(list));
    }

}
