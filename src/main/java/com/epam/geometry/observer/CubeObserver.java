package com.epam.geometry.observer;

import com.epam.geometry.logic.Calculator;
import com.epam.geometry.logic.CubeData;
import com.epam.geometry.observable.CubeObservable;
import com.epam.geometry.observer.exceptions.SingletonInitException;


import java.util.HashMap;
import java.util.Map;

public class CubeObserver implements Observer<CubeObservable> {
    private final Calculator calculator;
    private static CubeObserver instance;
    private Map<Integer, CubeData> cubeParametersMap = new HashMap<>();

    public static void initInstance(Calculator calculator) {
        if(instance == null) {
            throw new SingletonInitException("You can't reinitialize singleton!");
        }
        instance = new CubeObserver(calculator);
    }

    public static CubeObserver getInstance() {
        if(instance == null) {
            throw new SingletonInitException("Singleton wasn't initialized!");
        }
        return instance;
    }

    public CubeObserver(Calculator calculator){
        this.calculator = calculator;
    }

    public CubeData getCubeData(Integer id){
        return cubeParametersMap.get(id);
    }

    @Override
    public void update(CubeObservable item) {
        double area = calculator.calculateArea(item);
        double volume = calculator.calculateVolume(item);
        CubeData params = new CubeData(area, volume);
        cubeParametersMap.put(item.getId(), params);
    }
}
