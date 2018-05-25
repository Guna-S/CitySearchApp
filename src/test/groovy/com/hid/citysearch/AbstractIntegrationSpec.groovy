package com.hid.citysearch

import io.restassured.RestAssured
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by rmurugaian on 5/25/2018.
 */
@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CitySearchAppApplication)
@ActiveProfiles("local")
class AbstractIntegrationSpec extends Specification {

    @LocalServerPort
    int serverPort

    def setup() {
        RestAssured.port = serverPort
    }


    def cleanup() {
        RestAssured.reset()
    }
}
