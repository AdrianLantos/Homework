package Exercise;

public enum Day {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private String name;

    Day(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Day{" +
                "name='" + name + '\'' +
                '}';
    }
}
