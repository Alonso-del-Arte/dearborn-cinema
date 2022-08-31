package com.dearborncinema.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the Screening class.
 * @author Alonso del Arte
 */
class ScreeningTest {

    private static final Random RANDOM = new Random();

    private static final String BLACK_SWAN_3_TITLE
            = "Black Swan 3: Back to the Lake";

    private static final String BLACK_SWAN_3_RATING_REASON
            = "For even more sex, violence and drug use than the first one";

    private static final Duration BLACK_SWAN_3_RUNNING_TIME
            = Duration.ofMinutes(90 + RANDOM.nextInt(30));

    private static final LocalDate TODAY = LocalDate.now();

    private static final LocalDate BLACK_SWAN_3_RELEASE_DATE
            = TODAY.plusYears(1).plusMonths(RANDOM.nextInt(12));

    private static final Movie BLACK_SWAN_3_MOVIE
            = new Movie(BLACK_SWAN_3_TITLE, MPAARating.R,
            BLACK_SWAN_3_RATING_REASON, BLACK_SWAN_3_RUNNING_TIME,
            BLACK_SWAN_3_RELEASE_DATE);

    @Test
    void testSetterForbidsScreeningForMoviePriorToRelease() {
        LocalDateTime prematureShowtime
                = LocalDateTime.of(TODAY.plusDays(1), LocalTime.NOON);
        Screening screening = new Screening(BLACK_SWAN_3_MOVIE,
                BLACK_SWAN_3_RELEASE_DATE.plusDays(1).atStartOfDay());
        String msg = "Since " + BLACK_SWAN_3_TITLE
                + " is slated for release on " + BLACK_SWAN_3_RELEASE_DATE
                + ", this test should not be able to change showtime to "
                + prematureShowtime;
        Throwable t = assertThrows(IllegalArgumentException.class, () -> {
            screening.setShowtime(prematureShowtime);
            System.out.println("Scheduled " + BLACK_SWAN_3_TITLE
                    + ", due for release on " + BLACK_SWAN_3_RELEASE_DATE
                    + ", for a screening on " + prematureShowtime);
        }, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        String datesMsg = "Exception message should contain dates "
                + BLACK_SWAN_3_RELEASE_DATE + " and " + prematureShowtime;
        assert excMsg.contains(BLACK_SWAN_3_RELEASE_DATE.toString()) : datesMsg;
        assert excMsg.contains(prematureShowtime.toString()) : datesMsg;
        System.out.println(excMsg);
    }

    @Test
    void testNoNullFieldsFromNoArgConstructor() {
        Screening screening = new Screening();
        assert screening.getMovie() != null : "Movie should not be null";
        assert screening.getShowtime() != null : "Showtime should not be null";
    }

    @Test
    void testNoScreeningForMoviePriorToRelease() {
        LocalDateTime prematureShowtime
                = LocalDateTime.of(TODAY.plusDays(1), LocalTime.NOON);
        String msg = "Should not be able to schedule " + BLACK_SWAN_3_TITLE
                + ", which is slated for release on "
                + BLACK_SWAN_3_RELEASE_DATE + ", for a " + prematureShowtime
                + " screening";
        Throwable t = assertThrows(IllegalArgumentException.class, () -> {
            Screening badScreening = new Screening(BLACK_SWAN_3_MOVIE,
                    prematureShowtime);
            System.out.println("Scheduled " + BLACK_SWAN_3_TITLE
                    + ", due for release on " + BLACK_SWAN_3_RELEASE_DATE
                    + ", for a screening on " + prematureShowtime + " as "
                    + badScreening);
        }, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        String datesMsg = "Exception message should contain dates "
                + BLACK_SWAN_3_RELEASE_DATE + " and " + prematureShowtime;
        assert excMsg.contains(BLACK_SWAN_3_RELEASE_DATE.toString()) : datesMsg;
        assert excMsg.contains(prematureShowtime.toString()) : datesMsg;
        System.out.println(excMsg);
    }

}
