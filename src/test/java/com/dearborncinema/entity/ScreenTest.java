package com.dearborncinema.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the Screen class. In this context, this does not refer to an actor's
 * recorded audition for a particular r&ocirc;le.
 * @author Alonso del Arte
 */
class ScreenTest {

    private static final Movie EXAMPLE_G_RATED_MOVIE = new Movie("Mulan",
            MPAARating.G, "", Duration.ofMinutes(88), LocalDate.of(1998, 6, 5));

    private static final Movie EXAMPLE_PG_RATED_MOVIE
            = new Movie("The Parent Trap", MPAARating.PG,
            "For some mild mischief", Duration.ofMinutes(128),
            LocalDate.of(1998, 7, 29));

    private static final Movie EXAMPLE_PG13_RATED_MOVIE = new Movie("Inception",
            MPAARating.PG13, "For sequences of violence and action throughout",
            Duration.ofMinutes(148), LocalDate.of(2010, 7, 16));

    private static final Movie EXAMPLE_R_RATED_MOVIE
            = new Movie("Ted 2", MPAARating.R,
            "For crude & sexual content, pervasive language, and some drug use",
            Duration.ofMinutes(115), LocalDate.of(2015, 6, 26));

    private static final Movie EXAMPLE_NC17_RATED_MOVIE
            = new Movie("Blue Is the Warmest Colour", MPAARating.NC17,
            "For explicit sexual content", Duration.ofMinutes(180),
            LocalDate.of(2013, 10, 27));

}
