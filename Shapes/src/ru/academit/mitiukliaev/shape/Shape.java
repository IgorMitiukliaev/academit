package ru.academit.mitiukliaev.shape;

public interface Shape extends Comparable<Shape> {
    double getWidth();

    double getHeight();

    double getArea();

    double getPerimeter();

}

