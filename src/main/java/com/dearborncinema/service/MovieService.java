package com.dearborncinema.service;

import com.dearborncinema.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieByID(int id);

    Movie addMovie(Movie movie);

    Movie updateMovie(Movie movie);

    Movie deleteMovieByID(int id);

}
