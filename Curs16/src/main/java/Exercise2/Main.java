package Exercise2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shop<Clothes> clothesShop = new Shop<>();
        clothesShop.addItemList(List.of(
                new Clothes("sacou", 300, Category.ON_SALE),
                new Clothes("bluza", 200, Category.NEW),
                new Clothes("shorts", 100, Category.NEW)));

        System.out.println(clothesShop.findByCategory(Category.NEW));
        System.out.println(clothesShop.findWithLowerPrice(210));
        System.out.println(clothesShop.minPriceFromCategory(Category.REFURBISHED));
        System.out.println(clothesShop.findByName("shorts"));
        System.out.println(clothesShop.removeItem("sacou"));
        clothesShop.putOnSale("shorts", 50);
        System.out.println(clothesShop.findByName("shorts"));
    }
}
