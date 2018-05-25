package com.hid.citysearch.config;

import com.hid.citysearch.domain.City;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by rmurugaian on 5/24/2018.
 */
@Configuration
public class CitySearchAppConfiguration {

    /**
     * We can also use database instead of this list.
     * insert all the cities name into database and query the same.
     * for simplicity i have used list here.
     */
    @Bean
    public List<City> cities(@Value("${city.input}") Resource resource) throws Exception {

        return Stream.ofAll(Files
                .readAllLines(Paths.get(resource.getURI()), StandardCharsets.UTF_8))
                .map(name -> City.builder().name(name.toUpperCase()).build())
                .toList();
    }
}
