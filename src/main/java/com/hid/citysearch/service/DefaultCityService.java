package com.hid.citysearch.service;

import com.hid.citysearch.domain.City;
import com.hid.citysearch.domain.CityRequestDTO;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


/**
 * @author rmurugaian 2018-05-24
 */
@Service
public class DefaultCityService implements CityService {

    private final List<City> cities;

    public DefaultCityService(final List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String searchCities(final CityRequestDTO cityRequestDTO) {

        return cities
                .filter(city -> city.getName().startsWith(cityRequestDTO.getStart().toUpperCase()))
                .slice(0, cityRequestDTO.getAtmost())
                .map(City::getName)
                .collect(Collectors.joining("\n"));

    }
}
