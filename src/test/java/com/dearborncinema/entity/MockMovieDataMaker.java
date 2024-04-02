package com.dearborncinema.entity;

import java.time.Duration;
import java.time.LocalDate;

public class MockMovieDataMaker {

    // TODO: Write tests for this
    public static String makeUpTitle() {
        return "SORRY, NOT IMPLEMENTED YET";
    }

    // TODO: Write tests for this
    public static MPAARating chooseRating() {
        return MPAARating.UNRATED;
    }

    // TODO: Write tests for this
    public static String makeUpRatingReason() {
        return "SORRY, NOT IMPLEMENTED YET";
    }

    // TODO: Write tests for this
    public static Duration chooseDuration() {
        return Duration.ZERO;
    }

    // TODO: Write tests for this
    public static LocalDate choosePremiereDate() {
        return LocalDate.now();
    }

}
