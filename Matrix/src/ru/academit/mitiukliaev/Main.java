package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.matrix.Matrix;
import ru.academit.mitiukliaev.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(10, 10);
        Matrix b = new Matrix(a);

        double[][] array = {{1, 2}, {3, 4}, {5, 6}};
        Matrix c = new Matrix(array);
        Vector v1 = new Vector(new double[]{3, 4, 5});
        Vector v2 = new Vector(new double[]{7, 8, 9, 10});
        Matrix d = new Matrix(new Vector[]{v1, v2});
        System.out.println(d.getWidth());

        d.setVector(0, new double[]{1, 1, 1, 1});
        System.out.println(d.getVector(0));
        System.out.println(d);
    }
}
