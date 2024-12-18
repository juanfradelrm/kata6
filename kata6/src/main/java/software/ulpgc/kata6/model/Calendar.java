package software.ulpgc.kata6.model;

import java.time.LocalDate;
import java.util.*;


public class Calendar {

    private final int year;
    private final Map<LocalDate, String> holidays;

    public Calendar(int year, Map<LocalDate, String> holidays) {
        this.year = year;
        this.holidays = holidays;
    }

    private boolean isHoliday(LocalDate localDate){
        return holidays.keySet().contains(localDate);
    }

    public Map<LocalDate, String> getHolidaysBetween(LocalDate startDate, LocalDate endDate){
        if(startDate.isAfter(endDate)) throw new IllegalArgumentException("The start date must be before the end date");
        LocalDate current = startDate;
        Map<LocalDate, String> result = new HashMap<>();
        while(!current.isAfter(endDate)){
            if(isHoliday(current)) result.put(current,holidays.get(current));
            current = current.plusDays(1);
        }
        return result;
    }

    public int getYear() {
        return year;
    }
}
