package ExtraMile;

public class Main {
    public static void main(String[] args) {
        FakeSet set = new FakeSet();
        FakeSet2 set2 = new FakeSet2();
        set.add(10);
        set.add(20);
        set.add(45);
        set.add(20);
        set.add(1);
        set.add(20);
        System.out.println(set);
        set.remove(20);
        System.out.println(set);

        set2.add(1);
        set2.add(10);
        set2.add(20);
        set2.add(45);
        set2.add(1);
        System.out.println(set2);
        set2.remove(20);
        System.out.println(set2);


    }
}
