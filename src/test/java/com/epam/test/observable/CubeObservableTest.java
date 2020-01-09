package com.epam.test.observable;

import com.epam.geometry.generator.IdGenerator;
import com.epam.geometry.model.Point;
import com.epam.geometry.observable.CubeObservable;
import com.epam.geometry.observer.Observer;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CubeObservableTest {
    private static final IdGenerator GENERATOR = mock(IdGenerator.class);

    @Test
    public void setPointsShouldInvokeUpdate() {
        Observer observer = mock(Observer.class);
        CubeObservable observable = new CubeObservable(
            GENERATOR,
            new Point(5, 5, 5),1
        );

        observable.addObserver(observer);
        observable.setPoint(new Point(1, 1, 1));
        verify(observer).update(observable);
        verifyNoMoreInteractions(observer);
    }
}
