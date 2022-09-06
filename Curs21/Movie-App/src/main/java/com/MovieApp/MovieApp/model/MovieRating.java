package com.MovieApp.MovieApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}