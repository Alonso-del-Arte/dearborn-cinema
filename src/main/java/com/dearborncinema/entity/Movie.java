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

    /**
     * No argument constructor. This is provided almost only because of the
     * Spring framework. This constructor initializes a <code>Movie</code>
     * object with title <i>Untitled</i>, no MPAA rating or rating reason, a
     * running time of zero minutes and a release date of today.
     */
    public Movie() {
        this.title = "Untitled";
        this.mpaaRating = MPAARating.UNRATED;
        this.mpaaRatingReason = "The MPAA has not reviewed this movie yet";
        this.runningTime = Duration.ZERO;
        this.releaseDate = LocalDate.now();
    }

    /**
     * Primary constructor. This is the constructor that should generally be
     * used
     * @param title The title of the movie. For example, <i>The Parent Trap</i>.
     * @param rating The MPAA rating. For example, PG, parental guidance
     *               suggested.
     * @param ratingReason The reason for the MPAA rating. For example, "For
     *                     some mild mischief". It may be the empty
     *                     <code>String</code> in the case of G-rated movies.
     * @param duration The running time. For example, 2 hours and 8 minutes.
     * @param premiereDate The date the movie premiered or will premiere. If the
     *                     movie has not premiered yet, it is considered
     *                     unavailable for screening until it does premiere.
     */
    public Movie(String title, MPAARating rating, String ratingReason,
                 Duration duration, LocalDate premiereDate) {
        this.title = "What?";// title;
        this.mpaaRating = MPAARating.NC17;// rating;
        this.mpaaRatingReason = "???";// ratingReason;
        this.runningTime = Duration.ZERO;// duration;
        this.releaseDate = LocalDate.now();// premiereDate;
    }

}
