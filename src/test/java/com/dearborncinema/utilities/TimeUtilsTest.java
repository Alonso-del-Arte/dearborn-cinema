package com.dearborncinema.utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TimeUtilsTest {

    private static final Random RANDOM = new Random();

    private static final DateTimeFormatter FORMATTER
            = DateTimeFormatter.ofPattern("EEE yyyy-MM-dd");

    @Test
    void testPreviousSameDayOneWeekBefore() {
        LocalDate origin = LocalDate.now();
        DayOfWeek day = origin.getDayOfWeek();
        LocalDate expected = origin.minusDays(7);
        LocalDate actual = TimeUtils.previous(origin, day);
        String msg = "Previous "
                + day.getDisplayName(TextStyle.FULL_STANDALONE, Locale.US)
                + " from today should be " + expected.format(FORMATTER);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testPrevious() {
        System.out.println("previous");
        final int daysPerNonLeapYear = 365;
        int numberOfYears = 9;
        int bound = numberOfYears * daysPerNonLeapYear;
        int daysToSubtract = RANDOM.nextInt(bound) + daysPerNonLeapYear;
        LocalDate expected = LocalDate.now().minusDays(daysToSubtract);
        DayOfWeek day = expected.getDayOfWeek();
        int daysToAdd = RANDOM.nextInt(6) + 1;
        LocalDate origin = expected.plusDays(daysToAdd);
        LocalDate actual = TimeUtils.previous(origin, day);
        String msg = "Previous "
                + day.getDisplayName(TextStyle.FULL_STANDALONE, Locale.US)
                + " from " + origin.format(FORMATTER) + " should be "
                + expected.format(FORMATTER);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testNext() {
        System.out.println("next");
        final int daysPerNonLeapYear = 365;
        int numberOfYears = 9;
        int bound = numberOfYears * daysPerNonLeapYear;
        int daysToAdd = RANDOM.nextInt(bound) + daysPerNonLeapYear;
        LocalDate expected = LocalDate.now().plusDays(daysToAdd);
        DayOfWeek day = expected.getDayOfWeek();
        int daysToSubtract = RANDOM.nextInt(6) + 1;
        LocalDate origin = expected.minusDays(daysToSubtract);
        LocalDate actual = TimeUtils.next(origin, day);
        String msg = "Next "
                + day.getDisplayName(TextStyle.FULL_STANDALONE, Locale.US)
                + " after " + origin.format(FORMATTER) + " should be "
                + expected.format(FORMATTER);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testNextSameDayOfWeekOneWeekAfter() {
        LocalDate origin = LocalDate.now();
        DayOfWeek day = origin.getDayOfWeek();
        LocalDate expected = origin.plusDays(7);
        LocalDate actual = TimeUtils.next(origin, day);
        String msg = "Next "
                + day.getDisplayName(TextStyle.FULL_STANDALONE, Locale.US)
                + " after today should be " + expected.format(FORMATTER);
        assertEquals(expected, actual, msg);
    }

}
