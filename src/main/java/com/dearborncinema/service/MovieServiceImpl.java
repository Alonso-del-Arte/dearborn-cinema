package com.dearborncinema.service;

import com.dearborncinema.dao.MovieDAO;
import com.dearborncinema.entity.Movie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDAO movieDAO;

    @Override
    public List<Movie> getAllMovies() {
        return this.movieDAO.findAll();
    }

    @Override
    public Movie getMovieByID(int id) {
        Optional<Movie> option = this.movieDAO.findById(id);
        return option.orElse(null);
    }

    @Override
    public Movie addMovie(Movie movie) {
        return this.movieDAO.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return this.movieDAO.save(movie);
    }

    @Override
    public Movie deleteMovieByID(int id) {
        Optional<Movie> option = this.movieDAO.findById(id);
        return option.orElse(null);
    }

}
