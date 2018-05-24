package com.hid.citysearch.service

import com.hid.citysearch.domain.City

import spock.lang.Specification
import spock.lang.Subject

/**
 * Created by rmurugaian on 5/24/2018.
 */
class DefaultCityServiceSpec extends Specification {

    @Subject
    CityService service

    def setup() {
        service = new DefaultCityService([])
    }

    def "SearchCities"() {

        when:
        def result = service.searchCities("che","3")

        then:
        repo.findByNameContainingOrderByNameAsc({it == "che"}) >> [City.builder().name("chennai").build()]

        result == "chennai"
    }
}
