package com.MovieApp.MovieApp.repository;

import com.MovieApp.MovieApp.model.MovieRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRatingRepository extends JpaRepository<MovieRating, Integer> {
}
