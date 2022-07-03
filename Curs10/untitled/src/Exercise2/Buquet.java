package Exercise2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Buquet {
    Set<String> flowerSet = new HashSet<>();

    public Collection<String> getAll(){
        return new HashSet<>(flowerSet);
    }

    public void add(String flower){
        flowerSet.add(flower);
    }

    public void remove(String flower){
        flowerSet.remove(flower);
    }
}
