package com.epam.geometry.observable;

import com.epam.geometry.model.Cube;
import com.epam.geometry.observer.Observer;

public interface Observable<T extends Cube> {
    void addObserver(Observer<T> observer);
}
