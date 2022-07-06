package ExtraMile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeSet2 {
    private String string = "";
    int[] array;

    @Override
    public String toString() {
        return "FakeSet2{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public void add(int element) {
        String checkString = string + element + ",";
        String[] checkArray = checkString.split(",");
        if (checkUnique(checkArray)) {
            string = string + element + ",";
            array = sort();
        }
    }


    private int[] sort() {
        int[] arraySorted = convertString(string);
        Arrays.sort(arraySorted);
        for (int i = 0; i < arraySorted.length; i++) {
            for (int j = i + 1; j < arraySorted.length; j++) {
                int max = 0;
                if (arraySorted[i] < arraySorted[j]) {
                    max = arraySorted[j];
                    arraySorted[j] = arraySorted [i];
                    arraySorted[i] = max;
                }
            }
        }

        return arraySorted;
    }

    private int[] convertString(String string) {
        String [] strings = string.split(",");
        int[] array = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            if(!strings[i].equals("")){
            array[i] = Integer.parseInt(strings[i]);
            }
        }
        return array;
    }

    private boolean checkUnique(String[] string) {
        boolean check = true;
        for (int i = 0; i < string.length ; i++) {
            for (int j = i + 1; j < string.length ; j++) {
                if (string[i].equals(string[j])) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public void remove(int element) {
        String[] strings = string.split(",");
        for (int i = 0; i < strings.length - 1; i++){
            if (strings[i].equals(String.valueOf(element))){
                string.replace(String.valueOf(element), "");
            }
        }
        array = sort();
    }

    public int get(int index) {
        return array[index];
    }
}
