package com.dearborncinema.utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Text;

class TimeUtilsTest {

    private static final Random RANDOM = new Random();

    @Test
    void testPrevious() {
        final int daysPerNonLeapYear = 365;
        int numberOfYears = 9;
        int bound = numberOfYears * daysPerNonLeapYear;
        int daysToSubtract = RANDOM.nextInt(bound) + daysPerNonLeapYear;
        LocalDate expected = LocalDate.now().minusDays(daysToSubtract);
        DayOfWeek day = expected.getDayOfWeek();
        int daysToAdd = RANDOM.nextInt(7) + 1;
        LocalDate origin = expected.plusDays(daysToAdd);
        LocalDate actual = TimeUtils.previous(origin, day);
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("EEE yyyy-MM-dd");
        String msg = "Previous "
                + day.getDisplayName(TextStyle.FULL, Locale.ROOT) + " from "
                + origin.format(formatter) + " should be "
                + expected.format(formatter);
        assertEquals(expected, actual, msg);
    }

}
