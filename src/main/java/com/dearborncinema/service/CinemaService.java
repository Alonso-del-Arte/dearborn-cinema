package com.dearborncinema.service;

import com.dearborncinema.entity.Cinema;

import java.util.List;

public interface CinemaService {

    List<Cinema> getAllCinemas();

    Cinema getCinemaByID(int id);

    Cinema addCinema(Cinema cinema);

    Cinema updateCinema(Cinema cinema);

    Cinema deleteCinemaByID(int id);

}
