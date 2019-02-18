package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.shape.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] arrayShapes = new Shape[7];

        arrayShapes[0] = new Square(20);
        arrayShapes[1] = new Circle(25);
        arrayShapes[2] = new Triangle(0, 0, 10, 0, 0, 20);
        arrayShapes[3] = new Rectangle(20, 5);
        arrayShapes[4] = new Triangle(0, 0, 20, 0, 0, 10);
        arrayShapes[5] = new Triangle(0, 0, 0, 100, 100, 0);
        arrayShapes[6] = new Circle(5);

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
