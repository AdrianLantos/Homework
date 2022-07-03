package Exercise1;

public class Main {
    public static void main(String[] args) {
        Basket basket1 = new Basket();
        basket1.add("Apple");
        basket1.add("Banana");
        basket1.add("Blueberry");
        basket1.add("Strawberry");
        basket1.add("Banana");
        basket1.add("Orange");

        System.out.println(basket1.count() + " " + basket1.coustumCount());
        System.out.println(basket1.find("Banana"));
        System.out.println(basket1.distinct());
        basket1.remove("Orange");
        System.out.println(basket1.position("Banana") + 1);

    }
}
