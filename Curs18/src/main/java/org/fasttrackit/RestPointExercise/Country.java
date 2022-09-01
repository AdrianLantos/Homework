package org.fasttrackit.RestPointExercise;

import java.util.List;
import java.util.Optional;

public class Country {
    private String name;
    private String capital;
    private long population;
    private String continent;
    private Optional<List<String>> neighbours;
    private int area;
    private int id;

    public Country(String name, String capital, long population, String continent, Optional<List<String>> neighbours, int area, int id) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.continent = continent;
        this.neighbours = neighbours;
        this.area = area;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }

    public Optional<List<String>> getNeighbours() {
        return neighbours;
    }

    public int getArea() {
        return area;
    }
}
