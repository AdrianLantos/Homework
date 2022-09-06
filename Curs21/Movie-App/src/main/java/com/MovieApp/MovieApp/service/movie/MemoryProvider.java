package com.MovieApp.MovieApp.service.movie;

import com.MovieApp.MovieApp.model.*;
import com.MovieApp.MovieApp.model.*;

import java.util.List;

public interface MemoryProvider {
    List<Movie> getMovies();

    List<MovieRating> getRatings();

    List<Studio> getStudios();

    List<Review> getReviews();

    List<Actor> getActors();
}
