package com.MovieApp.MovieApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
public class Actor {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;
    @Column
    private int birthYear;

    @ManyToMany
    @JoinTable(
            name = "movie_credited",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    @JsonIgnore
    private List<Movie> moviesCredited;

    public List<Movie> getMoviesActed() {
        return moviesCredited;
    }

    public Actor(Integer id, String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }
}