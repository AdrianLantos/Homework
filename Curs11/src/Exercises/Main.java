package Exercises;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Classroom classroom = new Classroom(new FileReader("Students/grades.txt").readStudents());
        ReportGenerator report = new ReportGenerator(new FileReader("Students/grades.txt").readStudents());
//      Cea mai mare nota este 17. Nu stiu daca este o greseala pe care trebuia sa o prindem sau daca ai vrut doar sa ai cea mai mare nota clara
        report.writeReport();

        System.out.println("Average grade for Computer Science is " + classroom.getAverageGrade("Computer Science"));
        System.out.println("Best grade for Physics is " + classroom.getMaxGrade("Physics"));
        System.out.println("Worst Grade for History is " + classroom.getWorstGrade("History"));
        System.out.println("Best overall grade is " + classroom.getMaxGrade());
        System.out.println("Grades for Mathematics are " + classroom.getGradesForDiscipline("Mathematics"));
        System.out.println("Duilio Marius has the folowing grades " + classroom.getGradesForStudent("Duilio Marius"));
    }
}
