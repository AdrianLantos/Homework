package Exercise4;

public class Students {
    private String name;
    private double grade;

    private static double sum;

    private static int studentNr;

    public Students(String name, int grade) {
        this.name = name;
        this.grade = grade;
        studentNr++;
        sum += grade;

    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public static double average(){
        return sum / studentNr;
    }


}
