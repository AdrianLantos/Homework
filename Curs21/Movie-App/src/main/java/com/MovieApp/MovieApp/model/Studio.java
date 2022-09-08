package com.MovieApp.MovieApp.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = "studio")
    private List<Movie> moviesProduced;

    public Studio(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }
}