package Exercise4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Enum<Weekday>, List<String>> schedule=new HashMap<>();
        schedule.put(Weekday.MONDAY,List.of("sport","sleep"));
        schedule.put(Weekday.TUESDAY,List.of("reading", "wasting time"));
        schedule.put(Weekday.WEDNESDAY,List.of("sport", "lounge about"));
        schedule.put(Weekday.THURSDAY,List.of("take it easy","learning IT"));
        schedule.put(Weekday.FRIDAY,List.of("sport", "burning daylight"));
        schedule.put(Weekday.SATURDAY,List.of("recharging batteries"));
        schedule.put(Weekday.SUNDAY,List.of("ask oneself why I have not done more"));

        System.out.println(schedule);
        System.out.println(schedule.get(Weekday.FRIDAY));
    }
}
