package com.dearborncinema.dao;

import com.dearborncinema.entity.Screening;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningDAO extends JpaRepository<Screening, Integer> {
}
