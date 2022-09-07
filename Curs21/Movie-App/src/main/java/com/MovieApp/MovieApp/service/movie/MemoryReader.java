package com.MovieApp.MovieApp.service.movie;

import com.MovieApp.MovieApp.model.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MemoryReader implements MemoryProvider {
    private final List<Movie> movies;
    private final List<MovieRating> ratings;
    private final List<Review> reviews;
    private final List<Actor> actors;
    private final List<Studio> studios;

    public MemoryReader() {
        this.movies = readMovies();
        this.ratings = readRatings();
        this.actors = readActors();
        this.reviews = readReview();
        this.studios = readStudios();
    }

    @Override
    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public List<MovieRating> getRatings() {
        return ratings;
    }

    @Override
    public List<Studio> getStudios() {
        return studios;
    }

    @Override
    public List<Review> getReviews() {
        return reviews;
    }

    @Override
    public List<Actor> getActors() {
        return actors;
    }


    private Movie lineToMovie(Integer id, String line) {
        String[] tokens = line.split("\\|");
        return new Movie(id , tokens[0],Integer.parseInt(tokens[1]));
    }
    private List<Movie> readMovies() {
        AtomicInteger id = new AtomicInteger(0);
        try {
            return Files.lines(Path.of("src/main/resources/movie.txt"))
                    .map(line -> lineToMovie(id.getAndIncrement(), line))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Review lineToReview(String line) {
        String[] tokens = line.split("\\|");
        return new Review(tokens[0],tokens[1]);
    }
    private List<Review> readReview() {
        try {
            return Files.lines(Path.of("src/main/resources/review.txt"))
                    .map(line -> lineToReview(line))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private MovieRating lineToRating(String line) {
        String[] tokens = line.split("\\|");
        return new MovieRating(Integer.parseInt(tokens[0]),tokens[0]);
    }
    private List<MovieRating> readRatings() {
        try {
            return Files.lines(Path.of("src/main/resources/movierating.txt"))
                    .map(line -> lineToRating(line))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Actor lineToActor(Integer id, String line) {
        String[] tokens = line.split("\\|");
        return new Actor(id, tokens[0],Integer.parseInt(tokens[1]));
    }
    private List<Actor> readActors() {
        AtomicInteger id = new AtomicInteger(0);
        try {
            return Files.lines(Path.of("src/main/resources/actor.txt"))
                    .map(line -> lineToActor(id.getAndIncrement() ,line))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Studio lineToStudio(String line) {
        String[] tokens = line.split("\\|");
        return new Studio(tokens[0],tokens[1]);
    }
    private List<Studio> readStudios()  {
        try {
            return Files.lines(Path.of("src/main/resources/studio.txt"))
                    .map(line -> lineToStudio(line))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
