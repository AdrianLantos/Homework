public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(sumEven(11));
        System.out.println(palindromeCheck("Ana", palindromeReverse("Ana")));
        System.out.println(palindromeCharCheck("racecar"));
    }

    public static int sumEven (int n){
        if(n <= 0){
            return 0;
        }
        if(n % 2 != 0){
            --n;
        }
        return n + sumEven(n - 2);
    }
    public static String palindromeReverse(String word) {
        if (word.isEmpty())
            return word;
        else return palindromeReverse(word.substring(1)) + word.charAt(0);
    }

    public static boolean palindromeCharCheck(String word) {
        if (word.length() == 1) {
            return true;
        } else if (word.charAt(0) == word.charAt(word.length() - 1)) {
            try {
                return palindromeCharCheck(word.substring(2, word.length() - 2));
            }catch (StringIndexOutOfBoundsException e){
                return true;
            }
        }
        return false;
    }

    public static boolean palindromeCheck(String word, String comparable) {
        return word.equalsIgnoreCase(comparable);
    }

    public static int DigitSum(int n) {
        if (n == 0)
            return 0;
        return (n % 10 + DigitSum(n / 10));
    }

    public static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}
