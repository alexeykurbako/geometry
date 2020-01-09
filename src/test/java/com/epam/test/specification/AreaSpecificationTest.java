package com.epam.test.specification;

import com.epam.geometry.generator.IdGenerator;
import com.epam.geometry.logic.Calculator;
import com.epam.geometry.model.Cube;
import com.epam.geometry.model.Point;
import com.epam.geometry.repository.specification.AreaSpecification;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class AreaSpecificationTest {
    private static final IdGenerator GENERATOR = mock(IdGenerator.class);
    private static final Calculator CALCULATOR = mock(Calculator.class);
    private static final double MIN_AREA = 5.0;
    private static final double MAX_AREA = 7.0;
    private static final AreaSpecification SPECIFICATION = new AreaSpecification(CALCULATOR, MIN_AREA, MAX_AREA);
    private static final Cube FIRST_CUBE = new Cube(GENERATOR, new Point(1,1,1), 1);
    private static final Cube SECOND_CUBE = new Cube(GENERATOR, new Point(5,5,5), 2);

    @Test
    public void shouldReturnTrueWhenCubeSupplied() {
        when(CALCULATOR.calculateArea(FIRST_CUBE)).thenReturn(6.0);
        boolean result = SPECIFICATION.specified(FIRST_CUBE);
        Assert.assertTrue(result);
        verify(CALCULATOR).calculateArea(FIRST_CUBE);
        verifyNoMoreInteractions(CALCULATOR);
    }

    @Test
    public void shouldReturnFalseWhenCubeSupplied() {
        when(CALCULATOR.calculateArea(SECOND_CUBE)).thenReturn(12.0);
        boolean result = SPECIFICATION.specified(SECOND_CUBE);
        Assert.assertFalse(result);
        verify(CALCULATOR).calculateArea(SECOND_CUBE);
        verifyNoMoreInteractions(CALCULATOR);
    }
}
