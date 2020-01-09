package com.epam.test.specification;

import com.epam.geometry.generator.IdGenerator;
import com.epam.geometry.model.Cube;
import com.epam.geometry.model.Point;
import com.epam.geometry.repository.specification.DistanceToCubeSpecification;
import org.junit.Assert;
import org.junit.Test;

public class DistanceToCubeSpecificationTest {
    private static final IdGenerator GENERATOR = new IdGenerator();
    private static final double MIN_DISTANCE = 1.0;
    private static final double MAX_DISTANCE = 5.0;
    private static final Cube FIRST_CUBE = new Cube(GENERATOR, new Point(-2,-2,0), 4);
    private static final Cube SECOND_CUBE = new Cube(GENERATOR, new Point(5,5,5), 9);
    private static final DistanceToCubeSpecification SPECIFICATION = new DistanceToCubeSpecification(MIN_DISTANCE, MAX_DISTANCE);
    @Test
    public void shouldReturnTrueWhenCubeSupplied() {
        boolean result = SPECIFICATION.specified(FIRST_CUBE);
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenCubeSupplied() {
        boolean result = SPECIFICATION.specified(SECOND_CUBE);
        Assert.assertFalse(result);
    }
}
