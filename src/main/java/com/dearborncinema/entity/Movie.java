package com.dearborncinema.entity;

import java.time.Duration;
import java.time.LocalDateTime;

public class Movie {

    private String title;

    private MPAARating mpaaRating;

    private String mpaaRatingReason;

    private Duration runningTime;

    private LocalDateTime releaseDate;

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

    public LocalDateTime getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

}
