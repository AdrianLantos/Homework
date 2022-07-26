import Exercise2.Person;
import Exercise2.UncheckedException;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void instantiateClass(){
        Person person = new Person("Alexandru", 40);
    }

    @Test
    public void instantiateInvalidClassObject(){
       try {
           Person person = new Person(null , 1);
       }catch (UncheckedException e){
       }
       try {
           Person person = new Person("Dumitru" , -1);
       }catch (UncheckedException e){
       }
    }

}
