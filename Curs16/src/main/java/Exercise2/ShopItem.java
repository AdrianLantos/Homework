package Exercise2;

public interface ShopItem {
    String name();
    int price();
    Category category();

    void setCategory(Category category);

    void setPrice(int salePrice);
}
