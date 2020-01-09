package com.epam.geometry.repository.specification;

import com.epam.geometry.model.Cube;

public class IdSpecification implements Specification {
    private final Integer id;

    public IdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specified(Cube cube) {
        return id.equals(cube.getId());
    }
}
