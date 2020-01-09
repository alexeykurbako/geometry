package com.epam.geometry.model;

import com.epam.geometry.generator.IdGenerator;

import java.util.Objects;

public class Cube {

    private Point point;
    private double length;
    private Integer id;

    public Cube(IdGenerator idGenerator, Point point, double length) {
        this.point = point;
        this.length = length;
        this.id = idGenerator.generateId();
    }

    public Integer getId() {
        return id;
    }

    public double getLength() {
        return length;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "point=" + point +
                ", length=" + length +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null ) {return false;}
        if(getClass() != obj.getClass()){return false;}
        Cube cube = (Cube) obj;
        if(length != cube.length){
            return false;
        }
        if(null == point){
            return point == cube.point;
        } else {
            if(!point.equals(cube.point)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, length);
    }
}