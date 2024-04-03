package com.dearborncinema.entity;

import java.time.Duration;
import java.util.Random;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    static final Random RANDOM = new Random();

    private static final String DEFAULT_RATING_REASON
            = "For mild violence, sexual content";

    private static final Duration DEFAULT_DURATION = Duration.ofMinutes(100);

    @Test
    void testGetTitle() {
        String expected = MockMovieDataMaker.makeUpTitle();
        Movie movie = new Movie(expected, MPAARating.UNRATED,
                DEFAULT_RATING_REASON, DEFAULT_DURATION,
                MockMovieDataMaker.LAST_FRIDAY);
        String actual = movie.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void testNoNullFieldsFromNoArgConstructor() {
        Movie movie = new Movie();
        assert movie.getTitle() != null : "Movie title should not be null";
        assert movie.getMpaaRating() != null : "MPAA rating should not be null";
        assert movie.getMpaaRatingReason() != null
                : "MPAA rating reason may be blank but should not be null";
        assert movie.getRunningTime() != null
                : "Running time should not be null";
        assert movie.getReleaseDate() != null
                : "Release date should not be null";
    }

}
