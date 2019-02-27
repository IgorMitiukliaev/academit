package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.shape.Shape;

import java.util.Comparator;

class AreaComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape2.getArea(), shape1.getArea());
    }
}
