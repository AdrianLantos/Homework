package Exercise1;

import java.util.*;

public class Basket {
    public List<String> fruitList = new ArrayList<>();

    public void add(String fruit) {
        fruitList.add(fruit);
    }

    public boolean find(String fruit) {
        //Poate fi folosita si metoda contains
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruit.equals(fruitList.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(String fruit) {
        if (find(fruit)) {
            fruitList.remove(fruit);
            return true;
        } else {
            return false;
        }
    }

    public int position(String fruit) {
        // Return multiple positions
        for (int i = 0; i < fruitList.size(); ++i) {
            if (fruit.equals(fruitList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public Collection<String> distinct() {
        return new HashSet<>(fruitList);
    }

    public int count(){
        return fruitList.size();
    }

    public int coustumCount(){
        int count = 0;
        for(String s: fruitList){
            count++;
        }
        return count;
    }
}
