package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.shape.*;

import java.util.Arrays;

public class Main {
    private static Shape getNMax(Shape[] array, int n) {
        Arrays.sort(array);
        return array[n];
    }

    public static void main(String[] args) {
        Shape[] arrayShapes = new Shape[7];

        arrayShapes[0] = new Square(20);
        arrayShapes[1] = new Circle(25);
        arrayShapes[2] = new Triangle(0, 0, 10, 0, 0, 20);
        arrayShapes[3] = new Rectangle(20, 5);
        arrayShapes[4] = new Triangle(0, 0, 20, 0, 0, 10);
        arrayShapes[5] = new Triangle(0, 0, 0, 100, 100, 0);
        arrayShapes[6] = new Circle(50);

        for (Shape e : arrayShapes) {
            System.out.println(e.getClass().getSimpleName() + " S = " + e.getArea());
        }

        System.out.println();

        int rank = 1;
        int n = arrayShapes.length - rank;

        Shape shapeRank = getNMax(arrayShapes, n);
        String name = shapeRank.getClass().getSimpleName();
        double area = shapeRank.getArea();

//      здесь будут warnings ))
        String ending = "th";
        switch (rank) {
            case 1:
                ending = "st";
                break;
            case 2:
                ending = "nd";
                break;
            case 3:
                ending = "rd";
                break;
        }
        System.out.println(rank + ending + " largest shape is " + name + " S = " + area);
    }
}
