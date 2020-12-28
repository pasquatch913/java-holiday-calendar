package com.pasquatch;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HolidayCalculatorUtilsTest {

    @Test
    public void canGetMemorialDay() {
        assertEquals(LocalDate.of(2020, 5, 25), HolidayCalculatorUtils.memorialDay(2020));
    }

    @Test
    public void canGetMemorialDay2021() {
        assertEquals(LocalDate.of(2021, 5, 31), HolidayCalculatorUtils.memorialDay(2021));
    }

    @Test
    public void canGetThanksgivingDay() {
        assertEquals(LocalDate.of(2020, 11, 26), HolidayCalculatorUtils.thanksgiving(2020));
    }

    @Test
    public void canGetChristmasDay() {
        assertEquals(LocalDate.of(2020, 12, 25), HolidayCalculatorUtils.christmas(2020));
    }

    @Test
    public void canGetChristmasDayObserved() {
        assertEquals(LocalDate.of(2021, 12, 24), HolidayCalculatorUtils.christmas(2021));
    }
}