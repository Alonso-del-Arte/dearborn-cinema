package com.dearborncinema.dao;

import com.dearborncinema.entity.Cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaDAO extends JpaRepository<Cinema, Integer> {
}
