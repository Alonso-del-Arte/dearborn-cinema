package com.dearborncinema.entity;

import static com.dearborncinema.entity.MovieTest.RANDOM;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the Screen class. In this context, this does not refer to an actor's
 * recorded audition for a particular r&ocirc;le.
 * @author Alonso del Arte
 */
class ScreenTest {

    private static final LocalDate TOMORROW = LocalDate.now().plusDays(1);

    static final Movie EXAMPLE_G_RATED_MOVIE = new Movie("Mulan", MPAARating.G,
            "", Duration.ofMinutes(88), LocalDate.of(1998, 6, 5));

    static final Movie EXAMPLE_PG_RATED_MOVIE
            = new Movie("The Parent Trap", MPAARating.PG,
            "For some mild mischief", Duration.ofMinutes(128),
            LocalDate.of(1998, 7, 29));

    static final Movie EXAMPLE_PG13_RATED_MOVIE = new Movie("Inception",
            MPAARating.PG13, "For sequences of violence and action throughout",
            Duration.ofMinutes(148), LocalDate.of(2010, 7, 16));

    static final Movie EXAMPLE_R_RATED_MOVIE = new Movie("Ted 2", MPAARating.R,
            "For crude & sexual content, pervasive language, and some drug use",
            Duration.ofMinutes(115), LocalDate.of(2015, 6, 26));

    private static final Movie EXAMPLE_NC17_RATED_MOVIE
            = new Movie("Blue Is the Warmest Colour", MPAARating.NC17,
            "For explicit sexual content", Duration.ofMinutes(180),
            LocalDate.of(2013, 10, 27));

    @Test
    void testSetCapacityRejectsNegativeCapacity() {
        Screen screen = new Screen();
        int badCapacity = -RANDOM.nextInt(128) - 2;
        String msg = "Should not be able to set capacity to " + badCapacity
                + " seats";
        Throwable t = assertThrows(IllegalArgumentException.class, () -> {
            screen.setCapacity(badCapacity);
            System.out.println("Somehow set capacity to " + screen.getCapacity()
                    + " seats");
        }, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        String specMsg = "Exception message should contain number "
                + badCapacity;
        assert excMsg.contains(Integer.toString(badCapacity)) : specMsg;
        System.out.println("\"" + excMsg + "\"");
    }

    @Test
    void testAdd() {
        System.out.println("add");
        Screen screen = new Screen();
        LocalDateTime showtime = LocalDateTime.of(TOMORROW, LocalTime.NOON);
        Screening screening = new Screening(EXAMPLE_G_RATED_MOVIE, showtime);
        boolean opResult = screen.add(screening);
        String msg = "Should be able to add screening of "
                + EXAMPLE_G_RATED_MOVIE.getTitle() + " on " + showtime
                + " to screen with no other scheduled screenings";
        assert opResult : msg;
    }

    // TODO: Uncomment out the following lines after the next commit
//    @Test
//    void testSchedulingConflictOtherMovieStillPlaying() {
//        fail("Resume work here");
//    }

}
