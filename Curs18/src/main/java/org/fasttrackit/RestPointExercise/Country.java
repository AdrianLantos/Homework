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

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setNeighbours(Optional<List<String>> neighbours) {
        this.neighbours = neighbours;
    }

    public void setArea(int area) {
        this.area = area;
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
