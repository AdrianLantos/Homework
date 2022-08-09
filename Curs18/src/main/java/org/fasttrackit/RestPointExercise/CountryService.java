package org.fasttrackit.RestPointExercise;

import java.io.IOException;
import java.util.List;

public class CountryService {
    List<Country> countryList;

    public List<Country> getCountryList() {
        return countryList;
    }

    public CountryService(String filePath) throws IOException {
        countryList = new CountryReader(filePath).getCountryList();
    }
}
