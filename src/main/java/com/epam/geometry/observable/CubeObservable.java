package com.epam.geometry.observable;

import com.epam.geometry.generator.IdGenerator;
import com.epam.geometry.model.Cube;
import com.epam.geometry.model.Point;
import com.epam.geometry.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class CubeObservable extends Cube implements Observable<Cube>  {

    private List<Observer<Cube>> observers = new ArrayList<>();

    public CubeObservable(IdGenerator generator, Point point, double length) {
        super(generator, point, length);
    }

    @Override
    public void setPoint(Point point) {
        super.setPoint(point);
        notifyObservers();
    }
    @Override
    public void setLength(double length) {
        super.setLength(length);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer<Cube> observer) {
        observers.add(observer);
    }

    private void notifyObservers(){
        observers.forEach(observer -> observer.update(this));
    }
}
