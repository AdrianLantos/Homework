package Exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {
    private List<Person> employeeList = new ArrayList<>();

    @Override
    public String toString() {
        return ""+employeeList;
    }

    public Person getManager(){
        for(int i = 0; i < employeeList.size(); i++){
            if(Objects.equals(employeeList.get(i).getPosition(), "manager")){
                return employeeList.get(i);
            }
        }
        return null;
    }

    public void employ (Person person, String position){
        if(!(getManager() == null) && position.equals("manager")){
            System.out.println("You already have a manager. Change his position or fire him before employing another one.");
        }else{
            employeeList.add(person);
            person.setPosition(position);
        }
    }

    public void fireByName (String name){
        for(int i = 0; i < employeeList.size(); i++){
            if(name.equals(employeeList.get(i).getName())){
                fire(employeeList.get(i));
            }
        }
    }
    public void fire (Person person){
        employeeList.remove(person);
    }

    public List<Person> getPersons(String profession){
        List<Person> list = new ArrayList<>();
        for (Person person : employeeList) {
            if (profession.equals(person.getPosition())) {
                list.add(person);
            }
        }
        return list;
    }

    public List<Person> getPersonsOlder(int age){
        List<Person> list = new ArrayList<>();
        for (Person person : employeeList) {
            if (age > person.getAge()) {
                list.add(person);
            }
        }
        return list;
    }

    public List<Person> getPerson(String filterName){
        List<Person> list = new ArrayList<>();
        for (Person person : employeeList) {
            if (person.getName().contains(filterName)) {
                list.add(person);
            }
        }
        return list;
    }

}
