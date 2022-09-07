package com.MovieApp.MovieApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
@TableGenerator(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private int year;

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "moviesCredited")
    private List<Actor> actorList;

    public Movie(Integer id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public void creditActor(Actor actor) {
        actorList.add(actor);
    }

}

