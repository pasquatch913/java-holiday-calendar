package com.pasquatch;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

@Getter
@AllArgsConstructor
public enum Holidays {

    NEW_YEARS_DAY("New Year's Day", HolidayCalculatorUtils::newYearsDay),
    MLK_JR_DAY("Martin Luther King Jr Day", HolidayCalculatorUtils::mlkDay),
    WASHINGTONS_BIRTHDAY("Washington's Birthday", HolidayCalculatorUtils::washingtonsBirthday),
    MEMORIAL_DAY("Memorial Day", HolidayCalculatorUtils::memorialDay),
    INDEPENDENCE_DAY("Independence Day", HolidayCalculatorUtils::independenceDay),
    LABOR_DAY("Labor Day", HolidayCalculatorUtils::laborDay),
    INDIGENOUS_PEOPLES_DAY("Indigenous People's Day", HolidayCalculatorUtils::indigenousPeoplesDay),
    VETERANS_DAY("Veterans' Day", HolidayCalculatorUtils::veteransDay),
    THANKSGIVING("Thanksgiving", HolidayCalculatorUtils::thanksgiving),
    CHRISTMAS("Christmas", HolidayCalculatorUtils::christmas);

    private final String name;
    private final Function<Integer, LocalDate> calculator;

    public static List<Holidays> getUSBankHolidays() {
        return List.of(
                NEW_YEARS_DAY,
                MLK_JR_DAY,
                WASHINGTONS_BIRTHDAY,
                MEMORIAL_DAY,
                INDEPENDENCE_DAY,
                LABOR_DAY,
                INDIGENOUS_PEOPLES_DAY,
                VETERANS_DAY,
                THANKSGIVING,
                CHRISTMAS
        );
    }

}
