package com.MovieApp.MovieApp.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private int year;

    @ManyToMany
    @JoinTable(
            name = "actors_credited",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actorList;

    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void creditActor(Actor actor) {
        actorList.add(actor);
    }
}

