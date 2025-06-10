package nen.co.doggo.dto.req;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record ScheduleRequest(
        LocalTime mondayFrom,
        LocalTime mondayTo,
        LocalTime tuesdayFrom,
        LocalTime tuesdayTo,
        LocalTime wednesdayFrom,
        LocalTime wednesdayTo,
        LocalTime thursdayFrom,
        LocalTime thursdayTo,
        LocalTime fridayFrom,
        LocalTime fridayTo,
        LocalTime saturdayFrom,
        LocalTime saturdayTo,
        LocalTime sundayFrom,
        LocalTime sundayTo
) {

    public boolean isDayValid(DayOfWeek day) {
        return switch (day) {
            case MONDAY -> mondayFrom.isBefore(mondayTo);
            case TUESDAY -> tuesdayFrom.isBefore(tuesdayTo);
            case WEDNESDAY -> wednesdayFrom.isBefore(wednesdayTo);
            case THURSDAY -> thursdayFrom.isBefore(thursdayTo);
            case FRIDAY -> fridayFrom.isBefore(fridayTo);
            case SATURDAY -> saturdayFrom.isBefore(saturdayTo);
            case SUNDAY -> sundayFrom.isBefore(sundayTo);
        };
    }

}
