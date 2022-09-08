package com.MovieApp.MovieApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
public class MovieRating {
    public MovieRating(int rating, String agency) {
        this.rating = rating;
        this.agency = agency;
    }

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private int rating;
    @Column
    private String agency;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private Movie movieList;
}