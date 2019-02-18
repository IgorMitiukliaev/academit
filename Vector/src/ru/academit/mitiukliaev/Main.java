package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.vector.*;

public class Main {
    public static void main(String[] args) {

        Vector vector1 = new Vector(1, 2, 3, 4, 5);

        int n = vector1.getDimension();

        Vector vector2 = new Vector(vector1);

        for (int i = 0; i < n; i++) {
            System.out.println(vector2.getCoordinate(i));
        }
        System.out.println(vector2.getDimension());

        double[] a = new double[]{1, 2, 3, 4, 5};
        Vector vector3 = new Vector(10, a);

        System.out.println(vector3);
    }
}