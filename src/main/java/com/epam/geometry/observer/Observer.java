package com.epam.geometry.observer;

import com.epam.geometry.model.Cube;

public interface Observer<T extends Cube> {
    void update(T item);
}
