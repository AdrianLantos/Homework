package ExtraMile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarShop {
    private final List<Car> carList;

    public CarShop(List<Car> carList) {
        this.carList = carList;
    }

    Map<String, Integer> numberOfcars() {
        Map<String, Integer> result = new HashMap<>();
        for (Car car : carList) {
            if (result.get(car.getName()) == null) {
                result.put(car.getName(), 1);
            } else {
                result.put(car.getName(), result.get(car.getName()) + 1);
            }
        }
        return result;
    }

    Map<String, Integer> nameToSumOfKm() {
        Map<String, Integer> result = new HashMap<>();
        for (Car car : carList) {
            if (result.get(car.getName()) == null) {
                result.put(car.getName(), car.getKm());
            } else {
                result.put(car.getName(), result.get(car.getName()) + car.getKm());
            }
        }
        return result;
    }

    Map<String, List<Car>> groupByRange() {
        Map<String, List<Car>> result = new HashMap<>();
        List<String> range = List.of("0 - 50,000", "50,001 - 100,000", "100,001 - 200,000", "> 200,000");
        for (String string : range) {
            List<Car> byRange = result.get(string);
            if (byRange == null) {
                byRange = new ArrayList<>();
                result.put(string, byRange);
            }
        }

        for (Car car : carList) {
            if (car.getKm() <= 50000) {
                result.get("0 - 50,000").add(car);
            } else if (car.getKm() <= 100000) {
                result.get("50,001 - 100,000").add(car);
            } else if (car.getKm() <= 200000) {
                result.get("100,001 - 200,000").add(car);
            } else {
                result.get("> 200,000").add(car);
            }
        }
        return result;
    }

    Map<String, List<Car>> groupByPrice() {
        Map<String, List<Car>> result = new HashMap<>();
        List<String> range = List.of("0 - 50,000", "50,001 - 100,000", "100,001 - 200,000", "> 200,000");
        for (String string : range) {
            List<Car> byRange = result.get(string);
            if (byRange == null) {
                byRange = new ArrayList<>();
                result.put(string, byRange);
            }
        }

        for (Car car : carList) {
            if (car.getPrice() <= 50000) {
                result.get("0 - 50,000").add(car);
            } else if (car.getPrice() <= 100000) {
                result.get("50,001 - 100,000").add(car);
            } else if (car.getPrice() <= 200000) {
                result.get("100,001 - 200,000").add(car);
            } else {
                result.get("> 200,000").add(car);
            }
        }
        return result;
    }

}
