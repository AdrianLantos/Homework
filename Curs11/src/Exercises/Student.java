package Exercises;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String discipline;
    private int grade;

    public Student(String name, String discipline, int grade) {
        this.name = name;
        this.discipline = discipline;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getGrade() {
        return grade;
    }
}
