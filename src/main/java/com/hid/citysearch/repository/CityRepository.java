package com.hid.citysearch.repository;

import com.hid.citysearch.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rmurugaian 2018-05-24
 */
public interface CityRepository extends JpaRepository<City, Long> {
}
