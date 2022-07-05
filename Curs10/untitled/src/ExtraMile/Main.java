package ExtraMile;

public class Main {
    public static void main(String[] args) {
        FakeSet set = new FakeSet();
        set.add(10);
        set.add(20);
        set.add(45);
        set.add(20);
        set.add(1);
        set.add(20);
        System.out.println(set);
        set.remove(20);
        System.out.println(set);

    }
}
