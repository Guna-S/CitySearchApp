package com.hid.citysearch.service;

import com.hid.citysearch.domain.City;
import com.hid.citysearch.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<City> searchCities(final String start, final String atmost) {
        return cityRepository.findAll();
    }
}
