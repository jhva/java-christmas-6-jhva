package christmas.constants;

public enum CalendarType {
    FRIDAY, SATURDAY, SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY;

    public void calculateOfDay(int day) {
        CalendarType[] cal = CalendarType.values();
        String today = String.valueOf(cal[day % 7]);
        System.out.println(today);
    }
}
