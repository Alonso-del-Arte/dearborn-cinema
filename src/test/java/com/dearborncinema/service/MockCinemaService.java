package com.dearborncinema.service;

import com.dearborncinema.entity.Cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockCinemaService implements CinemaService {

    @Override
    public List<Cinema> getAllCinemas() {
        return null;
    }

    @Override
    public Cinema getCinemaByID(int id) {
        return null;
    }

    @Override
    public Cinema addCinema(Cinema cinema) {
        return null;
    }

    @Override
    public Cinema updateCinema(Cinema cinema) {
        return null;
    }

    @Override
    public Cinema deleteCinemaByID(int id) {
        return null;
    }

}
