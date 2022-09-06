package com.MovieApp.MovieApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Review {

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private Movie movie;

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String text;
    @Column
    private String reviewer;

    public Review(String text, String reviewer) {
        this.text = text;
        this.reviewer = reviewer;
    }
}