public class Exercises {
    public static void main(String[] args) {
        ex2();
        ex3();
        ex5();
    }

    public static void ex5() {
        Bottle bottle1 = new Bottle(330, false);
        System.out.println(bottle1.getAvailableLiquid() + " ml available");
        bottle1.openBottle();
        bottle1.hasMoreLiquid();
        System.out.println(bottle1.emptyVolume() + " ml have been drunk");
        bottle1.drink(80);
        bottle1.closeBottle();
    }

    public static void ex3(){
        Product product1 = new Product("Guma", 10, 150, "Dulciuri");
        Product product2 = new Product("Jeleu", 8, 76, "Dulciuri");
        Product product3 = new Product("Pasta de dinti", 16, 46, "Ingrijire Personala");
        Product[] array = {product1, product2, product3};
        for(int index = 0; index < array.length; index++){
            System.out.println("Product name: " + array[index].getName());
            System.out.println("Price: " + array[index].getPrice());
            System.out.println("Quantity: " + array[index].getQuantity());
            System.out.println("Category: " + array[index].getCategory());
            System.out.println("Is in stock: " + array[index].hasStock());
            System.out.println("Does it satisfy a sweet tooth: " + array[index].isCategory("Dulciuri"));
            System.out.println("\n");
        }
    }

    public static void ex2() {
        Person person1 = new Person(21, "Arin", false);
        Person person2 = new Person(44, "Alina", true);
        Person person3 = new Person(30, "Dorin", false);
        Person[] array = {person1, person2, person3};
        for(int index = 0; index < array.length; index++){
            System.out.println("Name: " + array[index].getName());
            System.out.println("Age: " + array[index].getAge());
            System.out.println("Married: " + array[index].isMarried());
            System.out.println("\n");
        }

    }


}
