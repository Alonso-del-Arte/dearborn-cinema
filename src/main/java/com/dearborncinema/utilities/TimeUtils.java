package com.dearborncinema.utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class TimeUtils {

    /**
     * Determines the previous specified day of the week from a specified date.
     * For example, determine the previous Sunday from February 29, 2024, which
     * was a Thursday.
     * @param origin The date to reckon from. For example, February 29, 2024.
     * @param day The desired day of the week. For example, Sunday.
     * @return The nearest date prior to <code>origin</code> not equal to
     * <code>origin</code> that is of the specified day of the week. In the
     * example, this would be Sunday, February 25, 2024. Note that if
     * <code>origin</code> is itself of the specified day of the week, this
     * function returns a day a week prior to <code>origin</code>. For example,
     * the previous Thursday from February 29, 2024 is February 22, 2024.
     */
    public static LocalDate previous(LocalDate origin, DayOfWeek day) {
        LocalDate curr = origin;
        do {
            curr = curr.minusDays(1);
        } while (curr.getDayOfWeek() != day);
        return curr;
    }

}
