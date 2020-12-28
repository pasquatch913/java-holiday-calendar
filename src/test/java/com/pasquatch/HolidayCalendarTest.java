package com.pasquatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class HolidayCalendarTest {

    HolidayCalendar calculator = new HolidayCalendar();

    @Test
    public void testChristmas() {
        Assertions.assertTrue(calculator.isHoliday(LocalDate.of(2020, 12, 25)));
    }

    @Test
    public void testNotHoliday() {
        Assertions.assertFalse(calculator.isHoliday(LocalDate.of(2020, 12, 26)));
    }

    @Test
    public void testChristmasObserved() {
        Assertions.assertTrue(calculator.isHoliday(LocalDate.of(2021, 12, 24)));
    }

}