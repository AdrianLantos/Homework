import java.util.*;

public class Exercises {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //List<Integer> list = Parameters();
        //ex1(list);
        //ex2(list);

        //System.out.println("Please give the number you want to compare elements with");
        //int comparabila = scan.nextInt();
        //ex3(list, comparabila);

        //ex4(100);
        //ex5(100, 4);

        System.out.println("Please give a number of sentences or phrases");
        String fraza = scan.nextLine();
        ex6(fraza);

    }

    public static List<Integer> Parameters() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please type numbers you want in the sequence one by one. If you are done type 'done' ");
        List<Integer> list = new ArrayList<>();
        int index = 0;
        String element = scan.nextLine();
        while (!element.equalsIgnoreCase("done")) {
            if (isInt(element)) {
                list.add(index, Integer.valueOf(element));
                index++;
            } else {
                System.out.println("Please insert an int value or type 'done' if you are finished.");
            }
            element = scan.nextLine();
        }
        return list;
    }

    public static boolean isInt(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int ex1(List<Integer> list) {
        int sum = 0;
        for (int index = 0; index < list.size(); index++) {
            sum += list.get(index);
        }
        System.out.println("Sum of elements is " + sum);
        return sum;
    }

    public static int ex2(List<Integer> list) {
        List<Integer> printList = new ArrayList<>();
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) % 2 != 0) {
                printList.add(list.get(index));
            }
        }
        int size = printList.size();
        System.out.println("Number of odd elements is: " + size);
        return size;
    }

    public static List<Integer> ex3(List<Integer> list, int a) {
        int index = 0;
        List<Integer> numerMaiMari = new ArrayList<>();
        for (Integer integer : list) {
            if (a < integer) {
                numerMaiMari.add(index, integer);
                index++;
            }
        }
        System.out.println(numerMaiMari);
        return numerMaiMari;
    }

    public static void ex4(int target) {
        Random r = new Random();
        int totalDonati = 0;
        // Am scris metoda astfel incat sa nu se poata strange mai mult decat targetul.
        // Daca putem depasi targetul, totalDonati += r.nextInt(); - Numar aleatoriu pana la val maxim al int-ului
        while (totalDonati < target) {
            totalDonati += r.nextInt((target - totalDonati) + 1);
        }
        System.out.println("Multumim! Am reusit sa strangem suma dorita.");
    }

    public static void ex5(int target, int nrMaxim) {
        Random r = new Random();
        int totalDonati = 0;
        int random = r.nextInt(target + 1);
        for (int index = 0; index < nrMaxim; index++) {
            if (totalDonati == target) {
                System.out.println("Targetul a fost atins.");
                break;
            } else {
                totalDonati += random;
                random = r.nextInt((target - totalDonati) + 1);

            }
        }
        System.out.println("Multumim! Am reusit sa strangem: " + totalDonati);
    }

    public static void ex6(String fraze) {
        String[] stringArray = fraze.split("\\.");
        for (int index = 0; index < stringArray.length; index++) {
            if (stringArray[index].length() != 0 && stringArray[index].charAt(0) == ' ') {
                stringArray[index] = stringArray[index].substring(1);
            }
            System.out.println(stringArray[index] + ".");
        }
    }
}
