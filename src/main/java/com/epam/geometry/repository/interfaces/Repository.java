package com.epam.geometry.repository.interfaces;

import com.epam.geometry.model.Cube;
import com.epam.geometry.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository {
    void add(Cube cube);
    void remove(Cube cube);
    void update(Cube oldCube, Cube newCube);
    List<Cube> query(Specification specification);
    List<Cube> query(Specification specification, Comparator<Cube> comparator);
}
