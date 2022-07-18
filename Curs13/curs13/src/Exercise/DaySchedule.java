package Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaySchedule {
    private Day day;
    private List<String> activities;

    public DaySchedule(Day day, List<String> activity) {
        this.day = day;
        this.activities = activity;
    }

//    Metoda List.of() creaza Liste imutabile asa ca am mai scris un constructor ca sa fie mai rapid instantiatul de obiecte
    public DaySchedule(Day day, String... activity) {
        this.day = day;
        List<String> activities = new ArrayList<>();
        Collections.addAll(activities, activity);
        this.activities = activities;
    }


    public Day getDay() {
        return day;
    }

    public List<String> getActivity() {
        return activities;
    }

    public void addActivity(String activity) {
        if(activity == null){
            throw new NoActivityException("Activity is null. Please add a valid activity!");
        }
        this.activities.add(activity);
    }
}
