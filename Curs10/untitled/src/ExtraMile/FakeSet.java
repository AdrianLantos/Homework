package ExtraMile;

import java.util.*;

public class FakeSet {
    private List<Integer> list = new ArrayList<>();
    int[] array;

    @Override
    public String toString() {
        return "FakeSet{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public void add(int element) {
        List <Integer> checkList = new ArrayList<>(list);
        checkList.add(element);
        if (checkUnique(checkList)) {
            list.add(element);
            array = sort();
        }
        System.out.println(Arrays.toString(array));
    }


    private int[] sort() {
        int[] arraySorted = convertList(list);
        Arrays.sort(arraySorted);
//        for (int i = 0; i < arraySorted.length; i++) {
//            for (int j = i + 1; j < arraySorted.length; j++) {
//                int max = 0;
//                if (arraySorted[i] < arraySorted[j]) {
//                    max = arraySorted[j];
//                    arraySorted[j] = arraySorted [i];
//                    arraySorted[i] = max;
//                }
//            }
//        }

        return arraySorted;
    }

    private int[] convertList(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private boolean checkUnique(List<Integer> list) {
        boolean check = true;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public void remove(int element) {
        list.remove(new Integer(element));
        array = sort();
    }

    public int get(int index) {
        array = sort();
        return array[index];
    }
}
