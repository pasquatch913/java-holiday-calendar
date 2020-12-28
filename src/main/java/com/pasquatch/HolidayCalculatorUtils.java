package com.pasquatch;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class HolidayCalculatorUtils {

    public static LocalDate newYearsDay(Integer year) {
        LocalDate observedHoliday = LocalDate.of(year, 1, 1);
        return getObservedHolidayForDate(observedHoliday);
    }

    public static LocalDate mlkDay(Integer year) {
        return LocalDate.of(year, Month.JANUARY, 1)
                .with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.MONDAY));
    }

    public static LocalDate washingtonsBirthday(Integer year) {
        return LocalDate.of(year, Month.FEBRUARY, 1)
                .with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.MONDAY));
    }

    public static LocalDate memorialDay(Integer year) {
        return LocalDate.of(year, Month.MAY, 1)
                .with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
    }

    public static LocalDate independenceDay(Integer year) {
        LocalDate observedHoliday = LocalDate.of(year, Month.JULY, 4);
        return getObservedHolidayForDate(observedHoliday);
    }

    public static LocalDate laborDay(Integer year) {
        return LocalDate.of(year, Month.SEPTEMBER, 1)
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
    }

    public static LocalDate indigenousPeoplesDay(Integer year) {
        return LocalDate.of(year, Month.OCTOBER, 1)
                .with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.MONDAY));
    }

    public static LocalDate veteransDay(Integer year) {
        LocalDate observedHoliday = LocalDate.of(year, Month.NOVEMBER, 11);
        return getObservedHolidayForDate(observedHoliday);
    }

    public static LocalDate thanksgiving(Integer year) {
        return LocalDate.of(year, Month.NOVEMBER, 1)
                .with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.THURSDAY));
    }

    public static LocalDate christmas(Integer year) {
        LocalDate observedHoliday = LocalDate.of(year, Month.DECEMBER, 25);
        return getObservedHolidayForDate(observedHoliday);
    }

    public static LocalDate getObservedHolidayFunctionForYearAndDate(Integer year,
                                                                     Month month,
                                                                     Integer dayOfMonth) {
        LocalDate observedHoliday = LocalDate.of(year, month, dayOfMonth);
        return HolidayCalculatorUtils.getObservedHolidayForDate(observedHoliday);
    }

    private static LocalDate getObservedHolidayForDate(LocalDate observedHoliday) {
        if (observedHoliday.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            return observedHoliday.minusDays(1);
        }
        if (observedHoliday.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return observedHoliday.plusDays(1);
        }
        return observedHoliday;
    }

}
