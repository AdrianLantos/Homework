import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static Exercise1.FarenheitCelcisuConvertor.celsiusToFahrenheit;
import static Exercise1.FarenheitCelcisuConvertor.fahrenheitToCelsius;

public class FahrenheitCelciusConvertorTest {
    @Test
    public void fahrenheitMethodeReturnsDouble(){
        double result = fahrenheitToCelsius(50.3);
    }

    @Test
    public void fahrenheitMethodeReturnsCorrectValue(){
        double temperatureFahrenheit = 69.8;

        double result = fahrenheitToCelsius(temperatureFahrenheit);

        Assertions.assertThat(result).isEqualTo(21);
    }

    @Test
    public void celsiusMethodeReturnsDouble(){
        double result = celsiusToFahrenheit(21);
    }

    @Test
    public void celsiusMethodeReturnsCorrectValue(){
        double temperatureCelsius = 21;

        double result = celsiusToFahrenheit(temperatureCelsius);

        Assertions.assertThat(result).isEqualTo(69.8);
    }
}
