package com.dearborncinema.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

    private static final LocalDate TOMORROW = TODAY.plusDays(1);

    private static final LocalDate BLACK_SWAN_3_RELEASE_DATE
            = TODAY.plusYears(1).plusMonths(RANDOM.nextInt(12));

    private static final Movie BLACK_SWAN_3_MOVIE
            = new Movie(BLACK_SWAN_3_TITLE, MPAARating.R,
            BLACK_SWAN_3_RATING_REASON, BLACK_SWAN_3_RUNNING_TIME,
            BLACK_SWAN_3_RELEASE_DATE);

    private static Set<Screening> scheduleScreeningsFor(Movie movie) {
        Set<Screening> screenings = new HashSet<>();
        LocalDateTime monthFromToday = TODAY.plusMonths(1).atStartOfDay();
        for (LocalDateTime showtime = LocalDateTime.of(TOMORROW, LocalTime.NOON);
             showtime.isBefore(monthFromToday);
             showtime = showtime.plusHours(2)) {
            Screening screening = new Screening(movie, showtime);
            screenings.add(screening);
        }
        return screenings;
    }

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

    @Test
    void testReferentialEquality() {
        LocalDateTime showtime = LocalDateTime.of(BLACK_SWAN_3_RELEASE_DATE,
                LocalTime.of(20, 0));
        Screening screening = new Screening(BLACK_SWAN_3_MOVIE, showtime);
        assertEquals(screening, screening);
    }

    @Test
    void testNotEqualsNull() {
        LocalDateTime showtime = LocalDateTime.of(BLACK_SWAN_3_RELEASE_DATE,
                LocalTime.of(21, 0));
        Screening screening = new Screening(BLACK_SWAN_3_MOVIE, showtime);
        assertNotEquals(screening, null);
    }

    private Object giveObjDiffClass() {
        return "Avoid weak warning in IntelliJ, could suppress it, I suppose";
    }

    @Test
    void testNotEqualsDiffClass() {
        LocalDateTime showtime = LocalDateTime.of(BLACK_SWAN_3_RELEASE_DATE,
                LocalTime.of(21, 0));
        Screening screening = new Screening(BLACK_SWAN_3_MOVIE, showtime);
        assertNotEquals(screening, this.giveObjDiffClass());
    }

    @Test
    void testNotEqualsScreeningForOtherMovie() {
        LocalDateTime showtime = LocalDateTime.of(BLACK_SWAN_3_RELEASE_DATE,
                LocalTime.of(22, 0));
        Screening screeningTheaterA = new Screening(BLACK_SWAN_3_MOVIE,
                showtime);
        Screening screeningTheaterB
                = new Screening(ScreenTest.EXAMPLE_R_RATED_MOVIE, showtime);
        assertNotEquals(screeningTheaterA, screeningTheaterB);
    }

    @Test
    void testNotEqualsScreeningSameMovieDifferentTime() {
        LocalDateTime showtimeA = LocalDateTime.of(TODAY, LocalTime.NOON);
        LocalDateTime showtimeB = showtimeA.plusHours(4);
        Screening screeningAtNoon
                = new Screening(ScreenTest.EXAMPLE_PG13_RATED_MOVIE, showtimeA);
        Screening screeningAtFourOClock
                = new Screening(ScreenTest.EXAMPLE_PG13_RATED_MOVIE, showtimeB);
        assertNotEquals(screeningAtNoon, screeningAtFourOClock);
    }

    @Test
    void testEquals() {
        System.out.println("equals");
        LocalDateTime showtime = LocalDateTime.of(TODAY, LocalTime.NOON);
        Screening someScreening
                = new Screening(ScreenTest.EXAMPLE_PG_RATED_MOVIE, showtime);
        Screening sameScreening
                = new Screening(ScreenTest.EXAMPLE_PG_RATED_MOVIE, showtime);
        assertEquals(someScreening, sameScreening);
    }

    @Test
    void testHashCode() {
        System.out.println("hashCode");
        Set<Screening> screenings
                = scheduleScreeningsFor(ScreenTest.EXAMPLE_G_RATED_MOVIE);
        screenings.addAll(scheduleScreeningsFor(ScreenTest
                .EXAMPLE_PG_RATED_MOVIE));
        screenings.addAll(scheduleScreeningsFor(ScreenTest
                .EXAMPLE_PG13_RATED_MOVIE));
        screenings.addAll(scheduleScreeningsFor(ScreenTest
                .EXAMPLE_R_RATED_MOVIE));
        Set<Integer> hashes = new HashSet<>();
        for (Screening screening : screenings) {
            hashes.add(screening.hashCode());
        }
        int expected = screenings.size();
        int actual = hashes.size();
        String msg = "Screenings for " + expected
                + " movie and showtime combos should have as many hash codes";
        assertEquals(expected, actual, msg);
    }

    // TODO: Write test for hashCode()

    @Test
    void testNoNullFieldsFromNoArgConstructor() {
        Screening screening = new Screening();
        assert screening.getMovie() != null : "Movie should not be null";
        assert screening.getShowtime() != null : "Showtime should not be null";
    }

}
