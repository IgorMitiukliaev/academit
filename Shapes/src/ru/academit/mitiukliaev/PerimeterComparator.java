package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.shape.Shape;

import java.util.Comparator;

class PerimeterComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape2.getPerimeter(), shape1.getPerimeter());
    }
}
