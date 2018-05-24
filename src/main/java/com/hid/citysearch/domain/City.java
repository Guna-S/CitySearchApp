package com.hid.citysearch.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author rmurugaian 2018-05-24
 */
@Builder
@Entity
@Getter
public class City {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
