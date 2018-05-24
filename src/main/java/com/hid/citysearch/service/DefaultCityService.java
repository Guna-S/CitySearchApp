package com.hid.citysearch.service;

import com.hid.citysearch.domain.City;
import com.hid.citysearch.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * @author rmurugaian 2018-05-24
 */
@Service
public class DefaultCityService implements CityService {

    private final CityRepository cityRepository;

    public DefaultCityService(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public String searchCities(final String start, final String atmost) {

        return cityRepository.findByNameContainingOrderByNameAsc(start)
                .stream()
                .filter(city -> city.getName().toLowerCase().startsWith(start.toLowerCase()))
                .limit(Long.valueOf(atmost))
                .map(City::getName)
                .collect(Collectors.joining("\n"));
    }
}
