package Exercise1;

public class FarenheitCelcisuConvertor {
    public static void main(String[] args) {

    }

    public static double fahrenheitToCelsius(double temperature){
        return (temperature-32)*5/9;
    }


    public static double celsiusToFahrenheit(double temperature){
        return (temperature)*9/5 +32;
    }
}
