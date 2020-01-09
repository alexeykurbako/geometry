package com.epam.geometry.repository.specification;

import com.epam.geometry.model.Cube;

public interface Specification {
    boolean specified(Cube quadrilateral);
}
