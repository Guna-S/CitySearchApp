package com.hid.citysearch.service;

import com.hid.citysearch.domain.City;

import java.util.List;

/**
 * @author rmurugaian 2018-05-24
 */
public interface CityService {

    List<City> searchCities(final String start, final String atmost);
}
