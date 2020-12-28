package com.pasquatch;

import lombok.Getter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public class HolidayCalendar {

    private final Map<String, Function<Integer, LocalDate>> holidayMap = new HashMap<>();

    public HolidayCalendar() {
//        default constructor supports US bank holidays only
//        https://www.opm.gov/policy-data-oversight/pay-leave/federal-holidays/#url=Overview
        Holidays.getUSBankHolidays().forEach(holiday ->
                holidayMap.put(holiday.getName(), holiday.getCalculator()));
    }

    public void addHoliday(String holidayKey, Function<Integer, LocalDate> holidayCalculator) {
        if (holidayMap.containsKey(holidayKey)) {
            throw new RuntimeException(
                    String.format("Holiday key %s already configured for this calendar. Please choose another.",
                            holidayKey));
        }

        holidayMap.put(holidayKey, holidayCalculator);
    }

    public void updateHolidayCalculator(String holidayKey, Function<Integer, LocalDate> holidayCalculator) {
        if (!holidayMap.containsKey(holidayKey)) {
            throw new RuntimeException(
                    String.format("No holiday with key %s configured for this calendar. " +
                                    "Please use the addHoliday method to add a new holiday.",
                            holidayKey));
        }

        holidayMap.put(holidayKey, holidayCalculator);
    }

    public Map<String, LocalDate> getHolidaysForYear(Integer year) {
        return holidayMap.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().apply(year)
                ));
    }

    public Boolean isHoliday(LocalDate date) {
        Integer year = date.getYear();
        return holidayMap.values().stream()
                .anyMatch(n -> date.equals(n.apply(year)));
    }

}
