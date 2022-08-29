package com.dearborncinema.entity;

import java.time.LocalDateTime;

public class Screening {

    private Movie title;

    private LocalDateTime time;

    public Movie getMovie() {
        return this.title;
    }

    public void setMovie(Movie movie) {
        this.title = movie;
    }

    public LocalDateTime getShowtime() {
        return this.time;
    }

    public void setShowtime(LocalDateTime time) {
        this.time = time;
    }

}
