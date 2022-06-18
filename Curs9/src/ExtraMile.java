import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExtraMile {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = randomNumberList();
        /*List<Integer> list1 = randomNumberList();
        List<Integer> list2 = randomNumberList();
        List<Integer> list3 = randomNumberList();
        listOfLists.add(list1);
        listOfLists.add(list3);
        listOfLists.add(list2);
        */

        System.out.println(listOfLists);

        System.out.println(min(max(listOfLists)));
    }

    //Nu era nevoie de metoda asta, dar am inceput de la idea sa scriu mai usor listele
    //Se creaza o lista cu un nr. random de liste ce la randul lor contin un numar random de elemente aleatorii.
    public static List<List<Integer>> randomNumberList() {
        Random r = new Random();
        int random = r.nextInt(50);
        List<List<Integer>> list = new ArrayList<>();
        List <Integer> sublist = new ArrayList<>();

        for (int counter = 0; counter < r.nextInt(7) + 1; counter++) {
            for (int index = 0; index < r.nextInt(6) + 1; index++) {
                sublist.add(index, random);
                random = r.nextInt(50);
            }
            list.add(counter, sublist);
            sublist = new ArrayList<>();
        }
        return list;
    }

    public static List<Integer> max(List<List<Integer>> list) {
        int max = 0;
        List<Integer> listOfMax = new ArrayList<>();

        for (int counter = 0; counter < list.size(); counter++) {
            for (int index = 0; index < list.get(counter).size(); index++) {
                if (list.get(counter).get(index) > max) {
                    max = list.get(counter).get(index);
                }
            }
            listOfMax.add(max);
            max = 0;
        }

        return listOfMax;
    }

    public static Integer min(List<Integer> list) {
        int min = Integer.MAX_VALUE;

        for (int index = 0; index < list.size(); index++) {
            if (min > list.get(index)) {
                min = list.get(index);
            }
        }
        return min;
    }
}
