package com.MovieApp.MovieApp.service.movie;

import com.MovieApp.MovieApp.repository.*;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;
    private final ActorRepository actorRepository;
    private final MovieRatingRepository movieRatingRepository;
    private final StudioRepository studioRepository;

    public MovieService(MemoryProvider memoryProvider,
                        MovieRepository movieRepository,
                        ReviewRepository reviewRepository,
                        ActorRepository actorRepository,
                        MovieRatingRepository movieRatingRepository,
                        StudioRepository studioRepository) {

        this.movieRepository = movieRepository;
        this.movieRatingRepository = movieRatingRepository;
        this.reviewRepository = reviewRepository;
        this.actorRepository = actorRepository;
        this.studioRepository = studioRepository;

        this.movieRepository.saveAll(memoryProvider.getMovies());
        this.movieRatingRepository.saveAll(memoryProvider.getRatings());
        this.reviewRepository.saveAll(memoryProvider.getReviews());
        this.actorRepository.saveAll(memoryProvider.getActors());
        this.studioRepository.saveAll(memoryProvider.getStudios());
    }

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    public ReviewRepository getReviewRepository() {
        return reviewRepository;
    }

    public ActorRepository getActorRepository() {
        return actorRepository;
    }

    public MovieRatingRepository getMovieRatingRepository() {
        return movieRatingRepository;
    }

    public StudioRepository getStudioRepository() {
        return studioRepository;
    }
}