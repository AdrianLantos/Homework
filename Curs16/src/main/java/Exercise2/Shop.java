package Exercise2;

import java.util.*;

public class Shop<T extends ShopItem> {
    private List<T> list = new ArrayList<>();

    public void addItemList(List<T> itemList) {
        list.addAll(itemList);
    }

    public void addItem(T item) {
        list.add(item);
    }

    public Optional<T> removeItem(String name) {
        for (T t : list) {
            if (t.name().equalsIgnoreCase(name)) {
                list.remove(t);
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public List<T> findByCategory(Category cat) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (t.category() == cat) {
                result.add(t);
            }
        }
        return result;
    }

    public List<T> findWithLowerPrice(int maxPrice) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (t.price() < maxPrice) {
                result.add(t);
            }
        }
        return result;
    }

    public Optional<T> findByName(String name) {
        for (T t : list) {
            if (t.name().equalsIgnoreCase(name)) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public Optional<T> minPriceFromCategory(Category cat) {
        int i = Integer.MAX_VALUE;
        Optional<T> result = Optional.empty();
        for (T t : list) {
            if (t.category() == cat) {
                if (t.price() < i) {
                    i = t.price();
                    result = Optional.of(t);
                }
            }
        }
        return result;
    }

    public void putOnSale(String name, int salePrice){
        for(T t : list){
            if(name.equalsIgnoreCase(t.name())){
                t.setPrice(salePrice);
                t.setCategory(Category.ON_SALE);
                break;
            }
        }
    }
}
