package ExtraMile;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String line = "Ana are multe mere si pere. Mai exact, 21.45 si 30 repsectiv.";
        String doubleTest = "123.3";
        String test2 ="1";

        System.out.println(line.replaceAll("m[^ ]*e", "REPLACED"));
        if(isDouble(line)){
            System.out.println("String is a double and can be converted into a double");
        }

        System.out.println(isDouble(doubleTest));
        System.out.println(isDoubleRegex(doubleTest));
        System.out.println(isDoubleRegex(test2));
        System.out.println(isDoubleRegex(line));
    }

    private static boolean isDoubleRegex(String string){
        if(Pattern.matches("\\d*", string)){
            return true;
        } else if (Pattern.matches("\\d*\\.\\d*", string)){
            return true;
        } else {
            return false;
        }
    }

//    Alternativa ce verifica direct daca un string poate fi convertit in double
    private static boolean isDouble(String string) {
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
