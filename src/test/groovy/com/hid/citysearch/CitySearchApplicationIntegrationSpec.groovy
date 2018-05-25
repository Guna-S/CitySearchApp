package com.hid.citysearch

import com.hid.citysearch.domain.City
import io.vavr.collection.List
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.context.WebApplicationContext

/**
 * Created by rmurugaian on 5/25/2018.
 */
class CitySearchApplicationIntegrationSpec extends AbstractIntegrationSpec {

    @Autowired
    private final List<City> cities;

    @Autowired
    WebApplicationContext context

    def "should boot up without errors"() {
        expect: "web application context exists"
        context != null
    }

    def "city list should be created"() {
        expect: "city list size should be 3"
        cities.size() == 3
    }
}
