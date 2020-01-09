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
import java.util.Comparator;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SortedRepositoryTest {
    private static final IdGenerator GENERATOR = mock(IdGenerator.class);
    private static final Cube FIRST_CUBE = new Cube(GENERATOR, new Point(4,4,4), 1);
    private static final Cube SECOND_CUBE = new Cube(GENERATOR, new Point(1,2,3), 2);
    private static final Cube THIRD_CUBE = new Cube(GENERATOR, new Point(5,2,4), 1);

    @Test
    public void ShouldReturnSortedByIdCubes() {
        Comparator<Cube> comparator = mock(Comparator.class);
        Specification specification = mock(Specification.class);
        when(specification.specified(any(Cube.class))).thenReturn(true);

        when(comparator.compare(FIRST_CUBE, SECOND_CUBE)).thenReturn(1);
        when(comparator.compare(SECOND_CUBE, THIRD_CUBE)).thenReturn(1);
        Repository repository = new RepositoryImplement();
        repository.add(FIRST_CUBE);
        repository.add(SECOND_CUBE);
        repository.add(THIRD_CUBE);
        List<Cube> expected = Arrays.asList(FIRST_CUBE, SECOND_CUBE, THIRD_CUBE);
        List<Cube> actual = repository.query(specification, comparator);

        Assert.assertEquals(expected, actual);
        Mockito.verify(specification).specified(FIRST_CUBE);
        Mockito.verify(specification).specified(SECOND_CUBE);
        Mockito.verify(specification).specified(THIRD_CUBE);
        Mockito.verifyNoMoreInteractions(specification);
    }
}
