package Exercise2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Vlad", 25, "black"));
        personList.add(new Person("Sebi", 28, "red"));
        personList.add(new Person("Tudor", 32, "black"));

        System.out.println(nameList(personList));
        System.out.println(mapNameToAge(personList));
        System.out.println(personOlderThan(30, personList));
        System.out.println(hairColorToName(personList));
        System.out.println(ageToPerson(personList));
    }
    public static List<String> nameList(List<Person> list){
        List<String> nume=new ArrayList<>();
        for(Person person :list){
            nume.add(person.getName());

        }
        return nume;
    }
    public static Map<String,Integer> mapNameToAge(List<Person> list){
        Map<String,Integer> result=new HashMap<>();
        for(Person person:list){
            result.put(person.getName(),person.getAge());
        }
        return result;

    }

    public static List<Person> personOlderThan(int age, List<Person> list){
        List<Person> result=new ArrayList<>();
        for(Person person: list){
            if(person.getAge()>age){
                result.add(person);
            }
        }
        return result;
    }

    public static Map<String,List<String>> hairColorToName(List<Person> list){
        Map<String,List<String>> result=new HashMap<>();
        for(Person person: list){
            List<String> nameList=result.get(person.getHairColour());
            if(nameList==null){
                nameList=new ArrayList<>();
                result.put(person.getHairColour(),nameList);
            }
            nameList.add(person.getName());
        }
        return result;

    }

    public static Map<Integer, List<Person>> ageToPerson(List<Person> list){
        Map<Integer, List<Person>> result=new HashMap<>();
        for(Person person: list){
            List<Person> namePersonList=result.get(person.getAge());
            if(namePersonList==null){
                namePersonList=new ArrayList<>();
                result.put(person.getAge(),namePersonList);
            }
            namePersonList.add(person);
        }
        return result;

    }

}
