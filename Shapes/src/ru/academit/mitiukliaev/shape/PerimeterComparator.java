package ru.academit.mitiukliaev.shape;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        double epsilon = 1e-10;
        if (Math.abs(shape1.getPerimeter() - shape2.getPerimeter()) <= epsilon) {
            return 0;
        }
        if (shape2.getPerimeter() - shape1.getPerimeter() > epsilon) {
            return 1;
        } else {
            return -1;
        }
    }
}
