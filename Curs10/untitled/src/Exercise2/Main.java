package Exercise2;

public class Main {
    public static void main(String[] args) {
        Buquet buquet = new Buquet();
        buquet.add("Gardenia");
        buquet.add("Rose");
        buquet.add("Iris");
        buquet.add("Lavender");
        buquet.add("Forget-me-not");
        buquet.add("Lilly");

        buquet.remove("Rose");
        System.out.println(buquet.getAll());
    }
}
