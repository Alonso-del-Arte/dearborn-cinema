package com.dearborncinema.entity;

import java.time.Duration;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the Screen class. In this context, this does not refer to an actor's
 * recorded audition for a particular r&ocirc;le.
 * @author Alonso del Arte
 */
class ScreenTest {

    private static final Movie EXAMPLE_G_RATED_MOVIE = new Movie("Mulan",
            MPAARating.G, "", Duration.ofMinutes(88), LocalDate.of(1998, 6, 5));

}
