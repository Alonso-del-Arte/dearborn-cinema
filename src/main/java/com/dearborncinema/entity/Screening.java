package com.dearborncinema.entity;

import java.time.LocalDateTime;

public class Screening {

    private Movie title;

    private LocalDateTime dateTime;

    public Movie getMovie() {
        return this.title;
    }

    public void setMovie(Movie movie) {
        this.title = movie;
    }

    public LocalDateTime getShowtime() {
        return this.dateTime;
    }

    public void setShowtime(LocalDateTime time) {
        this.dateTime = time;
    }

    public Screening() {}

    public Screening(Movie movie, LocalDateTime time) {
        this.title = movie;
        this.dateTime = time;
    }

}
