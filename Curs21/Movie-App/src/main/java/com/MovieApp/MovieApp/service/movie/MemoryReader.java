package com.MovieApp.MovieApp.service.movie;

import com.MovieApp.MovieApp.model.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class MemoryReader implements MemoryProvider {
    private final List<Movie> movies;
    private final List<MovieRating> ratings;
    private final List<Review> reviews;
    private final List<Actor> actors;
    private final List<Studio> studios;

    public MemoryReader() throws IOException {
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


    private Movie lineToMovie(String line) {
        String[] tokens = line.split("\\|");
        return new Movie(tokens[0],Integer.parseInt(tokens[1]));
    }
    private List<Movie> readMovies() throws IOException {
        return Files.lines(Path.of("src/main/resources/movie.txt"))
                .map(line -> lineToMovie(line))
                .toList();
    }

    private Review lineToReview(String line) {
        String[] tokens = line.split("\\|");
        return new Review(tokens[0],tokens[1]);
    }
    private List<Review> readReview() throws IOException {
        return Files.lines(Path.of("src/main/resources/review.txt"))
                .map(line -> lineToReview(line))
                .toList();
    }

    private MovieRating lineToRating(String line) {
        String[] tokens = line.split("\\|");
        return new MovieRating(Integer.parseInt(tokens[0]),tokens[0]);
    }
    private List<MovieRating> readRatings() throws IOException {
        return Files.lines(Path.of("src/main/resources/movierating.txt"))
                .map(line -> lineToRating(line))
                .toList();
    }

    private Actor lineToActor(String line) {
        String[] tokens = line.split("\\|");
        return new Actor(tokens[0],Integer.parseInt(tokens[1]));
    }
    private List<Actor> readActors() throws IOException {
        return Files.lines(Path.of("src/main/resources/actor.txt"))
                .map(line -> lineToActor(line))
                .toList();
    }

    private Studio lineToStudio(String line) {
        String[] tokens = line.split("\\|");
        return new Studio(tokens[0],tokens[1]);
    }
    private List<Studio> readStudios() throws IOException {
        return Files.lines(Path.of("src/main/resources/studio.txt"))
                .map(line -> lineToStudio(line))
                .toList();
    }
}
