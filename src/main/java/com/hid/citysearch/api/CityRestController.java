package com.hid.citysearch.api;

import com.hid.citysearch.domain.CityRequestDTO;
import com.hid.citysearch.exception.BadRequestException;
import com.hid.citysearch.service.CityService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String suggestCities(final CityRequestDTO cityRequestDTO) {

        if (StringUtils.isEmpty(cityRequestDTO.getStart())) {
            throw new BadRequestException("start keyword value must be present.");
        }

        if (cityRequestDTO.getAtmost() <= 0) {
            throw new BadRequestException("atmost value must be non negative");
        }

        return cityService.searchCities(cityRequestDTO);
    }
}
