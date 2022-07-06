package Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Classroom {
    private List<Student> studentList = new ArrayList<>();

    public Classroom(List<Student> list) {
        this.studentList = list;
    }

    public List<Integer> getGradesForDiscipline(String discipline) {
        if (!Objects.equals(discipline, "Physics") && !Objects.equals(discipline, "Mathematics") && !Objects.equals(discipline, "Computer Science") && !Objects.equals(discipline, "History")) {
            System.out.println("Please enter a valid discipline");
            return null;
        }
        List<Integer> gradeList = new ArrayList<>();
        for (Student student : studentList) {
            if (discipline.equals(student.getDiscipline())) {
                gradeList.add(student.getGrade());
            }
        }

        return gradeList;
    }

    public List<Integer> getGradesForStudent(String studentName) {
        List<Integer> gradeList = new ArrayList<>();
        boolean checkStudent = false;
        for (Student student : studentList) {
            if (studentName.equals(student.getName())) {
                gradeList.add(student.getGrade());
                checkStudent = true;
            }
        }
        if (!checkStudent) {
            System.out.println("Student not found");
            return null;
        }
        return gradeList;
    }

    public int getMaxGrade(String discipline) {
        if (!Objects.equals(discipline, "Physics") && !Objects.equals(discipline, "Mathematics") && !Objects.equals(discipline, "Computer Science") && !Objects.equals(discipline, "History")) {
            System.out.println("Please enter a valid discipline");
            return -1;
        }
        List<Integer> graderListForDiscipline = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getDiscipline().equals(discipline)) {
                graderListForDiscipline.add(student.getGrade());
            }
        }
        int maxGrade = 0;
        for (Integer integer : graderListForDiscipline) {
            if (maxGrade < integer) {
                maxGrade = integer;
            }
        }
        return maxGrade;
    }

    public int getMaxGrade() {
        int maxGrade = -1;
        for (Student student : studentList) {
            if (maxGrade < student.getGrade()) {
                maxGrade = student.getGrade();
            }
        }
        return maxGrade;
    }

    public Double getAverageGrade(String discipline) {
        if (!Objects.equals(discipline, "Physics") && !Objects.equals(discipline, "Mathematics") && !Objects.equals(discipline, "Computer Science") && !Objects.equals(discipline, "History")) {
            System.out.println("Please enter a valid discipline");
            return null;
        }
//        List<Integer> graderListForDiscipline = new ArrayList<>();
        double sum = 0;
        int listSize = 0;
        for (Student student : studentList) {
            if (student.getDiscipline().equals(discipline)) {
                sum += student.getGrade();
                listSize++;
            }
        }

        return sum / listSize;
    }

    public int getWorstGrade(String discipline) {
        if (!Objects.equals(discipline, "Physics") && !Objects.equals(discipline, "Mathematics") && !Objects.equals(discipline, "Computer Science") && !Objects.equals(discipline, "History")) {
            System.out.println("Please enter a valid discipline");
            return 0;
        }
        List<Integer> graderListForDiscipline = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getDiscipline().equals(discipline)) {
                graderListForDiscipline.add(student.getGrade());
            }
        }
        int worstGrade = 10;
        for (Integer integer : graderListForDiscipline) {
            if (worstGrade > integer) {
                worstGrade = integer;
            }
        }
        return worstGrade;
    }


}
