package org.fasttrackit.RestPointExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class CountryReader {
    private List<Country> countryList;

    private int id;

    public List<Country> getCountryList() {
        return countryList;
    }

    public CountryReader(String filePath) throws IOException {
        this.id = 1;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        countryList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            countryList.add(fromLine(line));
        }
    }

    private Country fromLine(String line) {
        String[] tokens = line.split(Pattern.quote("|"));
        Optional<List<String>> neighbourList;
        if (tokens.length == 6) {
            neighbourList = Optional.of(List.of(tokens[5].split("~")));
        } else {
            neighbourList = Optional.empty();
        }

        return new Country(tokens[0], tokens[1], Long.parseLong(tokens[2]), tokens[4], neighbourList, Integer.parseInt(tokens[3]), id++);
    }
}
