package com.dearborncinema.entity;

import org.junit.jupiter.api.Test;

class MovieTest {

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
