package com.pasquatch;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class HolidayCalculatorUtils {

    public static LocalDate newYearsDay(Integer year) {
        LocalDate observedHoliday = LocalDate.of(year, 1, 1);
        return getObservedHoliday(observedHoliday);
    }

    public static LocalDate mlkDay(Integer year) {
        return LocalDate.of(year, 1, 1)
                .with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.MONDAY));
    }

    public static LocalDate washingtonsBirthday(Integer year) {
        return LocalDate.of(year, 2, 1)
                .with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.MONDAY));
    }

    public static LocalDate memorialDay(Integer year) {
        return LocalDate.of(year, 5, 1)
                .with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
    }

    public static LocalDate independenceDay(Integer year) {
        LocalDate observedHoliday = LocalDate.of(year, 7, 4);
        return getObservedHoliday(observedHoliday);
    }

    public static LocalDate laborDay(Integer year) {
        return LocalDate.of(year, 9, 1)
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
    }

    public static LocalDate indigenousPeoplesDay(Integer year) {
        return LocalDate.of(year, 10, 1)
                .with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.MONDAY));
    }

    public static LocalDate veteransDay(Integer year) {
        LocalDate observedHoliday = LocalDate.of(year, 11, 11);
        return getObservedHoliday(observedHoliday);
    }

    public static LocalDate thanksgiving(Integer year) {
        return LocalDate.of(year, 11, 1)
                .with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.THURSDAY));
    }

    public static LocalDate christmas(Integer year) {
        LocalDate observedHoliday = LocalDate.of(year, 12, 25);
        return getObservedHoliday(observedHoliday);
    }

    private static LocalDate getObservedHoliday(LocalDate observedHoliday) {
        if (observedHoliday.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            return observedHoliday.minusDays(1);
        }
        if (observedHoliday.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return observedHoliday.plusDays(1);
        }
        return observedHoliday;
    }

}
