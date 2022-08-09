package org.fasttrackit.RestPointExercise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class CountryController {
    CountryService countryService = new CountryService("Files/countries.txt");

    public CountryController() throws IOException {
    }

    @GetMapping("countries")
    public List<Country> getCountryList(){
        return countryService.getCountryList();
    }

    @GetMapping("countries/names")
    public List<String> getNames(){
        return countryService.getCountryList().stream().map(Country::getName).toList();
    }

    @GetMapping("countries/{countryId}/capital")
    public String getCapital(@PathVariable int countryId){
        return countryService.getCountryList().stream().filter(country -> country.getId() == countryId).map(Country::getCapital).reduce(String::concat).get();
    }

    @GetMapping("countries/{countryId}/population")
    public long getPopulation(@PathVariable int countryId){
        return countryService.getCountryList().stream().filter(country -> country.getId() == countryId).map(Country::getPopulation).toList().get(0);
    }

    @GetMapping("continents/{continentName}/countries")
    public List<Country> getCountriesOnContinent(@PathVariable String continentName){
        return countryService.getCountryList().stream().filter(country -> country.getContinent().equalsIgnoreCase(continentName)).toList();
    }

    @GetMapping("countries/{countryId}/neighbours")
    public  List<String> getNeighbours(@PathVariable int countryId){
        return countryService.getCountryList().stream().filter(country -> country.getId() == countryId).map(Country::getNeighbours).toList().get(0).get();
    }

    @PostMapping("continents/{continentName}/countries")
    public List<Country> getCountriesOnContinentWithPopulation(@PathVariable String continentName,
    @RequestParam(required = false) Integer minPopulation){
        return countryService.getCountryList().stream().filter(country -> country.getContinent().equalsIgnoreCase(continentName)).filter(country -> country.getPopulation() >= minPopulation).toList();
    }
    @GetMapping("countries/neighbours")
    public List<Country> countryNeighboursAButNotB(@RequestParam(required = false) String includeNeighbour,@RequestParam(required = false) String excludeNeighbour){
        return countryService.getCountryList().stream().filter(country -> country.getNeighbours().isPresent()).filter(country -> country.getNeighbours().get().contains(includeNeighbour)).filter(country -> !country.getNeighbours().get().contains(excludeNeighbour)).toList();
    }
}
