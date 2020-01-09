package com.epam.geometry.repository.specification;

import com.epam.geometry.logic.Calculator;
import com.epam.geometry.model.Cube;

public class AreaSpecification implements Specification {
    private final Calculator calculator;
    private final double minFacet;
    private final double maxFacet;

    public AreaSpecification(Calculator calculator, double minFacet, double maxFacet) {
        this.calculator = calculator;
        this.minFacet = minFacet;
        this.maxFacet = maxFacet;
    }

    @Override
    public boolean specified(Cube cube) {
        double area = calculator.calculateArea(cube);
        return area >= minFacet && area <= maxFacet;
    }
}
