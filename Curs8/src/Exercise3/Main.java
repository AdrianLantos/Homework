package Exercise3;

public class Main {
    public static void main(String[] args) {
        Dog dog =new Dog();
        Cat cat = new Cat();
        Duck duck = new Duck();
        Mouse mouse = new Mouse();
        Chicken chicken = new Chicken();

        System.out.println(dog.talk());
        System.out.println(cat.walk());
        System.out.println(duck.eat());
        System.out.println(mouse.eat());
        System.out.println(chicken.walk());
    }
}
