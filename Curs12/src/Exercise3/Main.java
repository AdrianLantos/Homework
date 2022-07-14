package Exercise3;

import Exercise2.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Employee> list=List.of(new Employee("Tudor",30,"brown","Yonder",4000),
                new Employee("Adrian",26,"brown","Solvendi",3800),
                new Employee("Vlad",26,"blonde","Solvendi",2800),
                new Employee("Alex",38,"blonde","Fasttrack",5800));

        System.out.println(groupByCompany(list));
        System.out.println(sumOfAll(list));
        System.out.println(highestSalary(list));
        System.out.println(salarygraterthan(3900, list));


    }
    public static List<Employee> salarygraterthan(int ammount, List<Employee> list){
        List<Employee> result=new ArrayList<>();
        for(Employee employee: list){
            if(employee.getSalary()>ammount){
                result.add(employee);
            }
        }
        return result;
    }

    public static  Map<String, List<Person>> groupByCompany(List<Employee> list){
        Map<String, List<Person>> result=new HashMap<>();
        for(Employee employee: list){
            List<Person> companyEmployees=result.get(employee.getCompany());
            if(companyEmployees == null){
                companyEmployees= new ArrayList<>();
                result.put(employee.getCompany(), companyEmployees);
            }
            companyEmployees.add(employee);
        }
        return result;
    }

    public static int sumOfAll(List<Employee> list){
        int sum=0;
        for(Employee employee: list){
            sum+=employee.getSalary();
        }
        return sum;

    }

    public static String highestSalary(List<Employee> list){
        int maxSalary=0;
        String companyName=null;
        for(Employee employee: list){
            if(maxSalary< employee.getSalary()){
                maxSalary= employee.getSalary();
                companyName=employee.getCompany();
            }

        }
        return companyName;
    }
}