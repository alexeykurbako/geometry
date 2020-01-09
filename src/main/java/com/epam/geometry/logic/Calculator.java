package com.epam.geometry.logic;

import com.epam.geometry.logic.exceptions.CubeNotFoundException;
import com.epam.geometry.logic.exceptions.PlaneNotFoundException;
import com.epam.geometry.model.Cube;
import com.epam.geometry.model.Point;

public class Calculator {
    public double calculateArea(Cube cube){
        if(cube == null){
            throw new CubeNotFoundException("Cube wasn't found");
        }
        return Math.pow(cube.getLength(),2) * 6;
    }

    public double calculateVolume(Cube cube)  {
        if(cube == null){
            throw new CubeNotFoundException("Cube wasn't found");
        }
        return Math.pow(cube.getLength(),3);
    }

    private double calculation(Cube cube, Planes plane){
        double attitude = 0, delta;
        Point tempPoint = cube.getPoint();
        switch (plane){
            case XY:
                if(tempPoint.getZ() < 0){
                    delta = tempPoint.getZ() + cube.getLength();
                    if(delta > 0) {
                        attitude = delta / tempPoint.getZ();
                    }
                }
                break;
            case YZ:
                if(tempPoint.getX() < 0){
                    delta = tempPoint.getX() + cube.getLength();
                    if(delta > 0) {
                        attitude = delta / tempPoint.getX();
                    }
                }
                break;
            case XZ:
                if(tempPoint.getY() < 0){
                    delta = tempPoint.getY() + cube.getLength();
                    if(delta > 0) {
                        attitude = delta / tempPoint.getY();
                    }
                }
                break;
        }
        return attitude;
    }


    public double calculateRatioOfTheCutSurfaces(Cube cube, Planes plane){
        if(cube == null){
            throw new CubeNotFoundException("Cube wasn't found");
        }
        if(plane == null) {
            throw new PlaneNotFoundException("Plane wasn't found");
        }

        return Math.abs(calculation(cube,plane));
    }

    public boolean isBelongToCoordinatePlate(Cube cube){
        if(cube == null){
            throw new CubeNotFoundException("Cube not found");
        }
        Point tempPoint = cube.getPoint();
        return (tempPoint.getX() == 0 || tempPoint.getY() == 0 || tempPoint.getZ() == 0 );
    }
}
