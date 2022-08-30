package com.dearborncinema.entity;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the Screening class.
 * @author Alonso del Arte
 */
class ScreeningTest {

    @Test
    void testNoNullFieldsFromNoArgConstructor() {
        Screening screening = new Screening();
        assert screening.getMovie() != null : "Movie should not be null";
        assert screening.getShowtime() != null : "Showtime should not be null";
    }

    // TODO: Test that screening can't be scheduled for movie that hasn't been
    //  released yet

}
