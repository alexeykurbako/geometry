package com.epam.test.calculator;
import com.epam.geometry.generator.IdGenerator;
import com.epam.geometry.logic.Calculator;

import com.epam.geometry.logic.Planes;
import com.epam.geometry.logic.exceptions.CubeNotFoundException;
import com.epam.geometry.model.Cube;
import com.epam.geometry.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private final Calculator geometricCalculator = new Calculator();
    private final IdGenerator idGenerator = new IdGenerator();
    private final Cube testCube = new Cube(idGenerator, new Point(1,2,3), 1);
    @Test
    public void shouldCalculateAreaSupplied(){
        double expected = 6.0, delta = 0.01;
        //When
        double result = geometricCalculator.calculateArea(testCube);
        //Then
        Assert.assertEquals(expected, result, delta);
    }

    @Test(expected = CubeNotFoundException.class)
    public void shouldCalculateAreaGetNullSupplied(){
        geometricCalculator.calculateArea(null);
    }

    @Test
    public void shouldCalculateVolumeSupplied() {
        double expected = 1.0, delta = 0.01;
        //When
        double result = geometricCalculator.calculateVolume(testCube);
        //Then
        Assert.assertEquals(expected, result, delta);
    }

    @Test(expected = CubeNotFoundException.class)
    public void shouldCalculateVolumeGetNullSupplied() {
        geometricCalculator.calculateVolume(null);
    }

    @Test
    public void shouldCalculateRatioOfTheCutSurfacesSupplied(){
        double expected = 9.0, delta = 0.01;
        Cube givenCube = new Cube(idGenerator, new Point(-1,-1,-1), 10.0);

        double result = geometricCalculator.calculateRatioOfTheCutSurfaces(givenCube, Planes.XY);

        Assert.assertEquals(expected, result, delta);
    }

    @Test(expected = CubeNotFoundException.class)
    public void shouldExceptionCalculateRatioOfTheCutSurfacesSupplied() {
        geometricCalculator.calculateRatioOfTheCutSurfaces(null, Planes.XY);
    }

    @Test
    public void shouldIsBelongToCoordinatePlateSupplied(){
        Cube givenCube = new Cube(idGenerator, new Point(-1,-1,0), 10.0);

        boolean expected = geometricCalculator.isBelongToCoordinatePlate(givenCube);

        Assert.assertTrue(expected);
    }

    @Test(expected = CubeNotFoundException.class)
    public void shouldExceptionIsBelongToCoordinatePlateSupplied(){
        boolean expected =  geometricCalculator.isBelongToCoordinatePlate(null);
        Assert.assertTrue(expected);
    }

}
