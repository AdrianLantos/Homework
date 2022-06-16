package Exercise4;

public class Main {
    public static void main(String[] args) {
        Students stud1 = new Students("Arin", 9);
        Students stud2 = new Students("Vlad", 8);
        Students stud3 = new Students("Tudor", 5);
        Students sutd4 = new Students("Maria", 7);

        System.out.println(Students.average());
    }
}
