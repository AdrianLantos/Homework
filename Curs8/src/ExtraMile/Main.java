package ExtraMile;

public class Main {
    public static void main(String[] args) {
        int[] array = {17, 42, 2, 32, 5, 9, 4, 10, 7};
        ex1(array, 41);
        ex2(array, 18);
    }

    public static void ex1(int[] array, int target) {
        boolean pair = false;
        for (int i = 0; i < array.length; i++) {
            for (int I = i + 1; I < array.length; I++) {
                if (array[i] + array[I] == target) {
                    System.out.println(array[i] + " + " + array[I] + " = " + target);
                    pair = true;
                }
            }
        }
        if (!pair) System.out.println("No pair found");
    }

    public static void ex2(int[] array, int target) {
        boolean triplets = false;
        for (int i = 0; i < array.length; i++) {
            for (int t = i + 1; t < array.length; t++) {
                for (int I = t + 1; I < array.length; I++) {
                    if (array[i] + array[I] + array[t] == target) {
                        System.out.println(array[i] + " + " + array[t] + " + " + array[I] + " = " + target);
                        triplets = true;
                    }
                }
            }
        }
        if (!triplets) System.out.println("No triplet found");
    }
}
