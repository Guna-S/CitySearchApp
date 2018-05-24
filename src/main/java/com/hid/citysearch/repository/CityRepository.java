package com.hid.citysearch.repository;

import com.hid.citysearch.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author rmurugaian 2018-05-24
 */
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByNameContainingOrderByNameAsc(final String name);

}
