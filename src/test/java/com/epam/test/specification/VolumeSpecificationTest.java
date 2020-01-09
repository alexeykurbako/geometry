package com.epam.test.specification;

import com.epam.geometry.generator.IdGenerator;
import com.epam.geometry.logic.Calculator;
import com.epam.geometry.model.Cube;
import com.epam.geometry.model.Point;
import com.epam.geometry.repository.specification.VolumeSpecification;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class VolumeSpecificationTest {
    private static final IdGenerator GENERATOR = mock(IdGenerator.class);
    private static final Calculator CALCULATOR = mock(Calculator.class);
    private static final double MIN_VOLUME = 0.5;
    private static final double MAX_VOLUME = 2.0;
    private static final VolumeSpecification SPECIFICATION = new VolumeSpecification(CALCULATOR, MIN_VOLUME, MAX_VOLUME);
    private static final Cube FIRST_CUBE = new Cube(GENERATOR, new Point(1,1,1), 1);
    private static final Cube SECOND_CUBE = new Cube(GENERATOR, new Point(5,5,5), 2);

    @Test
    public void shouldReturnTrueWhenCubeSupplied() {
        when(CALCULATOR.calculateVolume(FIRST_CUBE)).thenReturn(1.0);
        boolean result = SPECIFICATION.specified(FIRST_CUBE);
        Assert.assertTrue(result);
        verify(CALCULATOR).calculateVolume(FIRST_CUBE);
        verifyNoMoreInteractions(CALCULATOR);
    }

    @Test
    public void shouldReturnFalseWhenCubeSupplied() {
        when(CALCULATOR.calculateVolume(SECOND_CUBE)).thenReturn(8.0);
        boolean result = SPECIFICATION.specified(SECOND_CUBE);
        Assert.assertFalse(result);
        verify(CALCULATOR).calculateVolume(SECOND_CUBE);
        verifyNoMoreInteractions(CALCULATOR);
    }
}
