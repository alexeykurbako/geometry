package com.epam.geometry.repository.comparator;

import com.epam.geometry.model.Cube;
import com.epam.geometry.model.Point;

import java.util.Comparator;

public class PointYComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube firstCube, Cube secondCube) {
        Point firstPoint = firstCube.getPoint();
        Point secondPoint = secondCube.getPoint();
        return Double.compare(firstPoint.getY(), secondPoint.getY());
    }
}
