package com.hid.citysearch.service;

import com.hid.citysearch.domain.CityRequestDTO;

/**
 * @author rmurugaian 2018-05-24
 */
public interface CityService {

    String searchCities(final CityRequestDTO cityRequestDTO);
}
