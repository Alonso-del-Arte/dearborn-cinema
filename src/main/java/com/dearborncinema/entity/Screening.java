package com.dearborncinema.entity;

import java.time.LocalDate;
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

    public void setShowtime(LocalDateTime rescheduledTime) {
        LocalDate releaseDate = this.getMovie().getReleaseDate();
        if (rescheduledTime.isBefore(releaseDate.atStartOfDay())) {
            String excMsg = "Can't reschedule movie for a screening on "
                    + rescheduledTime + " because its release date is "
                    + releaseDate;
            throw new IllegalArgumentException(excMsg);
        }
        this.dateTime = rescheduledTime;
    }

    public Screening() {
        this.title = new Movie();
        this.dateTime = LocalDateTime.now();
    }

    public Screening(Movie movie, LocalDateTime time) {
        LocalDateTime releaseDate = movie.getReleaseDate().atStartOfDay();
        if (time.isBefore(releaseDate)) {
            String excMsg = "Can't schedule " + movie.getTitle()
                    + " for a screening on " + time
                    + ", which is before the movie's release date of "
                    + releaseDate;
            throw new IllegalArgumentException(excMsg);
        }
        this.title = movie;
        this.dateTime = time;
    }

}
