package com.hid.citysearch.service

import com.hid.citysearch.domain.City
import com.hid.citysearch.domain.CityRequestDTO
import spock.lang.Specification
import spock.lang.Subject

import java.util.stream.Collectors

/**
 * Created by rmurugaian on 5/24/2018.
 */
class DefaultCityServiceSpec extends Specification {

    @Subject
    CityService service

    def setup() {
        service = new DefaultCityService(buildCities())
    }

    def "SearchCities"() {
        when:
        def result = service.searchCities(new CityRequestDTO(start: start, atmost: atmost))

        then:
        result == expected

        where:
        start | atmost | expected
        "che" | 3      | "CHENNAI\nCHENGALPATTU"
        "che" | 1      | "CHENNAI"
        "kan" | 10     | ""
    }


    def static buildCities() {

        ["CHENNAI", "VADAPALANI", "MADURAI", "CHENGALPATTU"]
                .stream()
                .map({ city -> City.builder().name(city).build() })
                .collect(Collectors.toList())

    }
}
