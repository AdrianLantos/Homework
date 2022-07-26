package Exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonService {
    private List<Person> list = new ArrayList<>();

    public PersonService(List<Person> list) {
        this.list = list;
    }

    public PersonService() {
    }

    public Person addPerson(Person person) {
//   Nu sunt sigur daca prin id setat te-ai referit ca trebuie sa fie imutabil
        list.add(person);

        return person;
    }

    public Person removePerson(int id) {
        for (Person person : list) {
            if (id == person.getId()) {
                list.remove(person);
                return person;
            }
        }
        throw new UncheckedException("Person not found");

    }

    public List<Person> getAllPersons() {
        return list;
    }

    public List<Person> getPersonsOldThan(int age) throws CheckedException {
        if (age >= 120) {
            throw new CheckedException("Age is too old");
        }
        List<Person> result = new ArrayList<>();
        for (Person person : list) {
            if (person.getAge() > age) {
                result.add(person);
            }
        }
        return result;
    }

    public List<String> getAllPersonNames() {
        List<String> result = new ArrayList<>();
        for (Person person : list) {
            result.add(person.getName());
        }
        return result;
    }

    public Person getPerson(String name)  {
        if (name != null) {
            for (Person person : list) {
                if (name.equalsIgnoreCase(person.getName())) {
                    return person;
                }
            }
        }else{
            throw new UncheckedException("Name cannot be null");
        }
        throw new UncheckedException("No Person with that name found");
    }

    public Person getPersonById(int id) {
        for (Person person : list) {
            if (id == person.getId()) {
                return person;
            }
        }
        throw new UncheckedException("No Person with that id found");
    }
}
