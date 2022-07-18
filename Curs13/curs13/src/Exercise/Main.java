package Exercise;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoActivitiesForDayException {
        DaySchedule monday = new DaySchedule(Day.MONDAY, "reading", "sport");
        DaySchedule tuesday = new DaySchedule(Day.TUESDAY, "learning", "surf the internet");
        DaySchedule wednesday = new DaySchedule(Day.WEDNESDAY, "playing", "sport");
        DaySchedule thursday = new DaySchedule(Day.THURSDAY, "sleeping", "housework");
        DaySchedule friday = new DaySchedule(Day.FRIDAY, "do homework", "sport");
        DaySchedule saturday = new DaySchedule(Day.SATURDAY, "walking", "sleep");
        DaySchedule sunday = new DaySchedule(Day.SUNDAY, "dancing on the moon");

        DailyPlanner dailyPlanner = new DailyPlanner(List.of(monday, tuesday, wednesday, thursday, friday, saturday, sunday));
        mainMenu(dailyPlanner);
        System.out.println(dailyPlanner.endPlaning());

    }

    public static void mainMenu(DailyPlanner dayschedule) throws NoActivitiesForDayException {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("******** Menu ********\nPlease choos an option:\n1) add an activity\n2) remove an activity\n3) list all activities\n4) end planing");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Please write the day and the actiuvity you want to add.");
                    System.out.print("day: ");
                    String day = scanner.nextLine();
                    System.out.print("activity: ");
                    String activity = scanner.nextLine();
                    dayschedule.addActivity(day, activity);
                    break;
                case "2":
                    System.out.println("Please write the day and an activity to remove from your schedule");
                    System.out.print("day: ");
                    day = scanner.nextLine();
                    System.out.print("activity: ");
                    activity = scanner.nextLine();
                    dayschedule.removeActivity(day, activity);
                    break;
                case "3":
                    System.out.println("Please write the name of the day you wish to see the activities for");
                    System.out.println("day: ");
                    day = scanner.nextLine();
                    System.out.println(dayschedule.getActivity(day));
                    break;
                case "4":
                    dayschedule.endPlaning();
                    break;
                default:
                    System.out.println("The character entered was not understood");


            }

        } while (!choice.equals("4"));
    }
}
