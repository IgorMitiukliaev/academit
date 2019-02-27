package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.shape.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] arrayShapes = new Shape[]{
                new Square(20),
                new Circle(25),
                new Triangle(0, 0, 10, 0, 0, 20),
                new Rectangle(20, 5),
                new Triangle(0, 0, 20, 0, 0, 10),
                new Triangle(0, 0, 0, 100, 100, 0),
                new Circle(5)
        };

        Arrays.sort(arrayShapes, new AreaComparator());
        for (Shape e : arrayShapes) {
            System.out.println(e + " S = " + e.getArea());
        }
        System.out.println();
        System.out.println(arrayShapes[0] + " has the 1st largest S=" + arrayShapes[0].getArea());
        System.out.println();

        Arrays.sort(arrayShapes, new PerimeterComparator());
        for (Shape e : arrayShapes) {
            System.out.println(e + " P = " + e.getPerimeter());
        }
        System.out.println();
        System.out.println(arrayShapes[1] + " has the 2nd largest P=" + arrayShapes[1].getPerimeter());
    }
}
