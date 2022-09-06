package com.MovieApp.MovieApp.model;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Studio {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String adress;

    public Studio(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }
}