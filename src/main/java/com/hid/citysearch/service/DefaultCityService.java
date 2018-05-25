package com.hid.citysearch.service;

import com.hid.citysearch.domain.City;
import com.hid.citysearch.domain.CityRequestDTO;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @author rmurugaian 2018-05-24
 */
@Service
public class DefaultCityService implements CityService {

    private static final Map<CityRequestDTO, String> CACHE = new ConcurrentHashMap<>();

    private final List<City> cities;

    public DefaultCityService(final List<City> cities) {
        this.cities = cities;
    }

    /**
     * This function is memoized.
     *
     * @param cityRequestDTO
     * @return
     */
    public String searchCities(final CityRequestDTO cityRequestDTO) {

        return CACHE.computeIfAbsent(cityRequestDTO, getCityNames());
    }

    private Function<CityRequestDTO, String> getCityNames() {

        return cityRequestDTO -> cities
                .filter(city -> city.getName().startsWith(cityRequestDTO.getStart().toUpperCase()))
                .slice(0, cityRequestDTO.getAtmost())
                .map(City::getName)
                .collect(Collectors.joining("\n"));
    }
}
