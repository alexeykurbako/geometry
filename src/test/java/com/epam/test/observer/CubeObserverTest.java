package com.epam.test.observer;

import com.epam.geometry.generator.IdGenerator;
import com.epam.geometry.logic.Calculator;
import com.epam.geometry.logic.CubeData;
import com.epam.geometry.model.Point;
import com.epam.geometry.observable.CubeObservable;
import com.epam.geometry.observer.CubeObserver;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


import static org.mockito.Mockito.when;

public class CubeObserverTest {
    private final static double AREA = 6.0;
    private final static double VOLUME = 1.0;
    private final static double DELTA = 0.001;
    private final static IdGenerator idGenerator = new IdGenerator();
    private final static CubeObservable CUBE = new CubeObservable(
            idGenerator,
            new Point(1.0, 1.0, 1.0), 1.0
    );

    @Test
    public void shouldUpdateAreaAndVolumeWhenCubeSupplied(){
        //given
        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.calculateArea(CUBE)).thenReturn(AREA);
        when(calculator.calculateVolume(CUBE)).thenReturn(VOLUME);

        CubeObserver observer = new CubeObserver(calculator);
        //when
        observer.update(CUBE);

        //then
        CubeData actual = observer.getCubeData(CUBE.getId());

        Assert.assertEquals(AREA, actual.getArea(), DELTA);
        Assert.assertEquals(VOLUME, actual.getVolume(), DELTA);

        Mockito.verify(calculator).calculateArea(CUBE);
        Mockito.verify(calculator).calculateVolume(CUBE);
        Mockito.verifyNoMoreInteractions(calculator);
    }
}
