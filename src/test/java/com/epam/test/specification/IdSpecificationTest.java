package com.epam.test.specification;

import com.epam.geometry.model.Cube;
import com.epam.geometry.repository.specification.IdSpecification;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;


public class IdSpecificationTest {
    private static final Integer ID = 0;
    private static final Cube CUBE = mock(Cube.class);
    private static final IdSpecification SPECIFICATION = new IdSpecification(ID);

    @Test
    public void ShouldReturnTrueWhenIdIsEqual() {
        boolean receive = SPECIFICATION.specified(CUBE);
        Assert.assertTrue(receive);
    }

    @Test
    public void ShouldReturnFalseWhenIdIsNotEqual() {
        boolean receive = SPECIFICATION.specified(CUBE);
        Assert.assertTrue(receive);
    }
}
