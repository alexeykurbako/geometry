package com.epam.test.repository;

import com.epam.geometry.generator.IdGenerator;
import com.epam.geometry.model.Cube;
import com.epam.geometry.model.Point;
import com.epam.geometry.repository.RepositoryImplement;
import com.epam.geometry.repository.interfaces.Repository;
import com.epam.geometry.repository.specification.Specification;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class RepositoryTest {
    private static final IdGenerator GENERATOR = mock(IdGenerator.class);
    private static final Cube FIRST_CUBE = new Cube(GENERATOR, new Point(4,4,4), 1);
    private static final Cube SECOND_CUBE = new Cube(GENERATOR, new Point(1,2,3), 2);
    private static final Cube THIRD_CUBE = new Cube(GENERATOR, new Point(5,3,1), 1);
    private static final Specification SPECIFICATION = mock(Specification.class);

    @Test
    public void ShouldReturnCubeWhenSpecificationSupplied() {

        when(SPECIFICATION.specified(FIRST_CUBE)).thenReturn(true);
        when(SPECIFICATION.specified(SECOND_CUBE)).thenReturn(false);
        when(SPECIFICATION.specified(THIRD_CUBE)).thenReturn(false);
        RepositoryImplement repository = new RepositoryImplement();
        repository.add(FIRST_CUBE);
        repository.add(SECOND_CUBE);
        repository.add(THIRD_CUBE);

        List<Cube> expected = Arrays.asList(FIRST_CUBE);
        List<Cube> actual = repository.query(SPECIFICATION);

        Assert.assertEquals(expected, actual);
        Mockito.verify(SPECIFICATION).specified(FIRST_CUBE);
        Mockito.verify(SPECIFICATION).specified(SECOND_CUBE);
        Mockito.verify(SPECIFICATION).specified(THIRD_CUBE);
        Mockito.verifyNoMoreInteractions(SPECIFICATION);
    }
}
