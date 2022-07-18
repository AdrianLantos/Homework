package Exercise;

import java.util.*;

public class DailyPlanner {
    private List<DaySchedule> list;

    public DailyPlanner(List<DaySchedule> list) {
        this.list = list;
    }

    public void addActivity(String day, String activity) {
        for (DaySchedule daySchedule : list) {
            if (daySchedule.getDay().name().equalsIgnoreCase(day)) {
                daySchedule.addActivity(activity);
            }
        }
    }

    public void removeActivity(String day, String activity) {
        boolean getError = true;
        for (DaySchedule daySchedule : list) {
            if (daySchedule.getDay().name().equalsIgnoreCase(day)) {
                for (String string : daySchedule.getActivity()) {
                    if (string.equals(activity)) {
                        getError = false;
                    }
                }
                daySchedule.getActivity().remove(activity);
            }
            if (getError) {
                throw new NoActivityException("Activity not found!");
            }
        }
    }

    public List<String> getActivity(String day) {
        for (DaySchedule daySchedule : list) {
            if (daySchedule.getDay().name().equalsIgnoreCase(day)) {
                return daySchedule.getActivity();
            }
        }
        return null;
    }

    public Map<Day, List<String>> endPlaning() throws NoActivitiesForDayException {
        Map<Day, List<String>> result = new HashMap<>();
        for (DaySchedule daySchedule : list) {
            List<String> activities = result.get(daySchedule.getDay());
            if (activities == null) {
                activities = daySchedule.getActivity();
                result.put(daySchedule.getDay(), activities);
            }
        }

        for(Map.Entry map: result.entrySet()){
            if(map.getValue() == null){
                throw new NoActivitiesForDayException(String.format("%s has no activities", map.getKey()));
            }
        }
        return result;
    }

}
