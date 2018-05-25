package com.hid.citysearch.domain;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by rmurugaian on 5/24/2018.
 */
@Getter
@Setter
public class CityRequestDTO {
    private String start;
    private int atmost;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityRequestDTO that = (CityRequestDTO) o;
        return atmost == that.atmost &&
                Objects.equal(start.toUpperCase(), that.start.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(start.toUpperCase(), atmost);
    }
}
