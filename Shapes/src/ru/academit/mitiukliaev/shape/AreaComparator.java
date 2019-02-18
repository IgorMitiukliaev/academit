package ru.academit.mitiukliaev.shape;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        double epsilon = 1e-10;
        if (Math.abs(shape1.getArea() - shape2.getArea()) <= epsilon) {
            return 0;
        }
        if (shape2.getArea() - shape1.getArea() > epsilon) {
            return 1;
        } else {
            return -1;
        }
    }
}
