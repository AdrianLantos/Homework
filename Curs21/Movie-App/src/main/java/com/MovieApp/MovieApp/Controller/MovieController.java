package com.MovieApp.MovieApp.Controller;

import com.MovieApp.MovieApp.model.Actor;
import com.MovieApp.MovieApp.model.Movie;
import com.MovieApp.MovieApp.service.movie.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("movies")
public class MovieController {
    private MovieService service;

    @GetMapping
    public List<Movie> getMovies() {
        return service.getMovieRepository().findAll();
    }

    @PutMapping("/{movieId}/actors/{actorId}")
    public Movie creditActor(
            @PathVariable Integer movieId,
            @PathVariable Integer actorId
    ) {
        Actor actor = service.getActorRepository().findById(actorId).orElseThrow(() -> new RuntimeException("Actor not found"));
        Movie movie = service.getMovieRepository().findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        movie.creditActor(actor);
        return movie;
    }
}
