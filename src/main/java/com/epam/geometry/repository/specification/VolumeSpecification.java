package com.epam.geometry.repository.specification;

import com.epam.geometry.logic.Calculator;
import com.epam.geometry.model.Cube;

public class VolumeSpecification implements Specification {
    private final Calculator calculator;
    private final double minFacet;
    private final double maxFacet;

    public VolumeSpecification(Calculator calculator, double minFacet, double maxFacet) {
        this.calculator = calculator;
        this.minFacet = minFacet;
        this.maxFacet = maxFacet;
    }

    @Override
    public boolean specified(Cube cube) {
        double volume = calculator.calculateVolume(cube);
        return volume >= minFacet && volume <= maxFacet;
    }
}
