package Exercise2and3;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Person {
    public String getFirstName();
    public String getLastName();
    public LocalDate getBirthday();
    public String getAddress();
}
