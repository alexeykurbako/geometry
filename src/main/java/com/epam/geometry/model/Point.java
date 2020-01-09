package com.epam.geometry.model;

import java.util.Objects;

public class Point{
        private final double x;
        private final double y;
        private final double z;

        public Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getZ() {
            return z;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null ) {return false;}
        if(getClass() != obj.getClass()){return false;}
        Point point = (Point) obj;
        if(x != point.x || y != point.y || z != point.z){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
