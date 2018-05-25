package com.hid.citysearch.service;

import com.hid.citysearch.domain.City;
import com.hid.citysearch.domain.CityRequestDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
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

    /**
     * @param cityRequestDTO
     * @return
     */
    @Cacheable("cities")
    public String searchCities(final CityRequestDTO cityRequestDTO) {

        return cities
                .stream()
                .filter(city -> city.getName().startsWith(cityRequestDTO.getStart().toUpperCase()))
                .limit(cityRequestDTO.getAtmost())
                .map(City::getName)
                .collect(Collectors.joining("\n"));
    }
}
