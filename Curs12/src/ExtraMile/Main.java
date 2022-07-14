package ExtraMile;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> list = List.of(new Car("BMW", 5, 120000, 25000),
                new Car("Renault", 14, 178000, 2000),
                new Car("Audi", 12, 250000, 6500),
                new Car("Audi", 2, 45000, 180000),
                new Car("BMW", 3, 98000, 200000));

        CarShop dealer = new CarShop(list);
        System.out.println(dealer.numberOfcars());
        System.out.println(dealer.groupByRange());
        System.out.println(dealer.nameToSumOfKm());
        System.out.println(dealer.groupByPrice());
    }

}
