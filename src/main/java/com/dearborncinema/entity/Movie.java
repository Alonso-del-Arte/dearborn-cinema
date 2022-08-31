package com.dearborncinema.entity;

import java.time.Duration;
import java.time.LocalDate;

public class Movie {

    private String title;

    private MPAARating mpaaRating;

    private String mpaaRatingReason;

    private Duration runningTime;

    private LocalDate releaseDate;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MPAARating getMpaaRating() {
        return this.mpaaRating;
    }

    public void setMpaaRating(MPAARating rating) {
        this.mpaaRating = rating;
    }

    public String getMpaaRatingReason() {
        return this.mpaaRatingReason;
    }

    public void setMpaaRatingReason(String ratingReason) {
        this.mpaaRatingReason = ratingReason;
    }

    public Duration getRunningTime() {
        return this.runningTime;
    }

    public void setRunningTime(Duration duration) {
        this.runningTime = duration;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Movie() {
        this.title = "Untitled";
        this.mpaaRating = MPAARating.UNRATED;
        this.mpaaRatingReason = "The MPAA has not reviewed this movie yet";
        this.runningTime = Duration.ZERO;
        this.releaseDate = LocalDate.now();
    }

    public Movie(String title, MPAARating rating, String ratingReason,
                 Duration duration, LocalDate premiereDate) {
        this.title = title;
        this.mpaaRating = rating;
        this.mpaaRatingReason = ratingReason;
        this.runningTime = duration;
        this.releaseDate = premiereDate;
    }

}
