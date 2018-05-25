package com.hid.citysearch.api

import com.hid.citysearch.AbstractIntegrationSpec
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus

/**
 * Created by rmurugaian on 5/25/2018.
 */
class CityRestControllerIntegrationSpec extends AbstractIntegrationSpec {

    def "suggest cities with not valid start"() {
        expect: "bad request"
        RestAssured
                .given()
                .get("suggest_cities")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
    }

    def "suggest cities with not valid atmost"() {
        expect: "bad request"
        RestAssured
                .given()
                .queryParam("start", "che")
                .get("suggest_cities")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
    }

    def "suggest cities with valid inputs"() {
        expect: "bad request"
        RestAssured
                .given()
                .queryParam("start", "che")
                .queryParam("atmost", "3")
                .get("suggest_cities")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.TEXT)
                .body(CoreMatchers.equalTo("CHENNAI\n" +
                "CHENGALPATTU"))
    }

}
