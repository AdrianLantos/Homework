package Execise1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String,Integer> studentMap=new HashMap<>();
        studentMap.put("Adrian",5);
        studentMap.put("Vlad",4);
        studentMap.put("Tudor",10);
        studentMap.put("Marc",9);
        studentMap.put("Alex",8);
        studentMap.put("Maria",2);
        studentMap.put("Ana",3);
        MapPrint(studentMap);
        maxGrade(studentMap);


    }

    public static void MapPrint(Map<String,Integer> map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(Map.Entry entry:entries){
            System.out.println(String.format("Student %s has %d grade.", entry.getKey(), entry.getValue()));
        }
    }

    public static void maxGrade(Map<String, Integer> map){
        String bestStudent = null;
        Set <String> key = map.keySet();
        int maxGrade = Integer.MIN_VALUE;
        for(String student : key){
            if(map.get(student) > maxGrade){
                maxGrade = map.get(student);
                bestStudent = student;
            }
        }
        System.out.println(String.format("Student %s has the best the grade: %d.", bestStudent, map.get(bestStudent)));
    }
}
