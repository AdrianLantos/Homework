package com.MovieApp.MovieApp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private int year;

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "moviesCredited")
    private List<Actor> actorList;

    @OneToMany(mappedBy = "movieList")
    private List<MovieRating> ratings;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    private Studio studio;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    public Movie(Integer id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public void creditActor(Actor actor) {
        actorList.add(actor);
    }

}

