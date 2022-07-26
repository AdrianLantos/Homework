import Exercise2.CheckedException;
import Exercise2.Person;
import Exercise2.PersonService;
import Exercise2.UncheckedException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceTest {
    @Test
    public void addPersonTest() {
        PersonService service = new PersonService();

        service.addPerson(new Person("Vlad", 26));
        service.addPerson(new Person("Trandafir Zamfirescu", 119));
    }

    @Test
    public void removePersonTest() {
        Person tudor = new Person("Tudor", 28);
        Person mircea = new Person("Mircea", 21);
        List<Person> list = new ArrayList<>();
        list.add(tudor);
        list.add(mircea);
        PersonService service = new PersonService(list);

        Assertions.assertThat(service.removePerson(tudor.getId())).isEqualTo(tudor);

    }

    @Test
    public void removeNonexistingPersonTest() {
        PersonService service = new PersonService();
        try {
            service.removePerson(213);
        } catch (UncheckedException e) {
        }
    }

    @Test
    public void getAllPersons() {
        Person vlad = new Person("Vlad", 26);
        Person trandafir = new Person("Trandafir Zamfirescu", 119);
        List<Person> list = List.of(vlad, trandafir);
        PersonService service = new PersonService(list);


        Assertions.assertThat(service.getAllPersons()).isEqualTo(list);
    }

    @Test
    public void getAllPersonNames() {
        Person tudor = new Person("Tudor", 28);
        Person mircea = new Person("Mircea", 21);
        List<Person> list = List.of(tudor, mircea);
        PersonService service = new PersonService(list);

        Assertions.assertThat(service.getAllPersonNames()).isEqualTo(List.of("Tudor", "Mircea"));
    }

    @Test
    public void getPersonTest() {
        Person vlad = new Person("Vlad", 26);
        Person trandafir = new Person("Trandafir Zamfirescu", 119);
        List<Person> list = List.of(vlad, trandafir);
        PersonService service = new PersonService(list);

        try {
            service.getPerson(null);
        } catch (UncheckedException e) {
        }
    }

    @Test
    public void getNonexistingPersontTest() {
        Person tudor = new Person("Tudor", 28);
        Person mircea = new Person("Mircea", 21);
        List<Person> list = List.of(tudor, mircea);
        PersonService service = new PersonService(list);

        try {
            service.getPerson("Eustache");
        } catch (UncheckedException e) {
        }
    }

    @Test
    public void getPersonByIdTest(){
        Person tudor = new Person("Tudor", 28);
        Person mircea = new Person("Mircea", 21);
        List<Person> list =List.of(tudor,mircea);
        PersonService service = new PersonService(list);

        try {
            service.getPersonById(213);
        }catch (UncheckedException e){

        }


    }


}
