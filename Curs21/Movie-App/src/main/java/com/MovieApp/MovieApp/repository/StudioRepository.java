package com.MovieApp.MovieApp.repository;

import com.MovieApp.MovieApp.model.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer> {
}
