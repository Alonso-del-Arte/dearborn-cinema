package com.dearborncinema.dao;

import com.dearborncinema.entity.Screen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenDAO extends JpaRepository<Screen, Integer> {
}
