package com.epam.geometry.repository.specification;

import com.epam.geometry.model.Cube;
import com.epam.geometry.model.Point;

public class DistanceToCubeSpecification implements Specification {
    private final double minFacet;
    private final double maxFacet;
    public DistanceToCubeSpecification(double minFacet, double maxFacet) {
        this.minFacet = minFacet;
        this.maxFacet = maxFacet;
    }
    private Point calculateCenterPoint(Cube cube){
        Point temp = cube.getPoint();
        Double length = cube.getLength();
        Point center = new Point(temp.getX() + length / 2, temp.getY() + length / 2, temp.getZ() + length / 2);
        return center;
    }

    private double calculateDistanceToCenter(Point centerPoint){
        double expression = Math.pow(centerPoint.getX(),2) + Math.pow(centerPoint.getY(),2) + Math.pow(centerPoint.getZ(),2);
        return Math.pow(expression,0.5);
    }

    @Override
    public boolean specified(Cube cube) {
        Point center = calculateCenterPoint(cube);
        double distance = calculateDistanceToCenter(center);
        return distance >= minFacet && distance <= maxFacet;
    }
}