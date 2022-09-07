package com.dearborncinema.service;

import com.dearborncinema.dao.CinemaDAO;
import com.dearborncinema.entity.Cinema;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaDAO cinemaDAO;

    @Override
    public List<Cinema> getAllCinemas() {
        return this.cinemaDAO.findAll();
    }

    @Override
    public Cinema getCinemaByID(int id) {
        Optional<Cinema> option = this.cinemaDAO.findById(id);
        return option.orElse(null);
    }

    @Override
    public Cinema addCinema(Cinema cinema) {
        return this.cinemaDAO.save(cinema);
    }

    @Override
    public Cinema updateCinema(Cinema cinema) {
        return this.cinemaDAO.save(cinema);
    }

    @Override
    public Cinema deleteCinemaByID(int id) {
        Optional<Cinema> option = this.cinemaDAO.findById(id);
        return option.orElse(null);
    }

}
