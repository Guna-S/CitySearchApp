package com.hid.citysearch.api;

import com.hid.citysearch.domain.City;
import com.hid.citysearch.service.CityService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * @author rmurugaian 2018-05-23
 */
@RestController
@Api
public class CityRestController {

    private final CityService cityService;

    public CityRestController(final CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/suggest_cities", produces = MediaType.TEXT_PLAIN_VALUE)
    public String suggestCities(@RequestParam final String start, @RequestParam final String atmost) {

        return cityService.searchCities(start, atmost);
    }
}
