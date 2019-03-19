package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.matrix.Matrix;
import ru.academit.mitiukliaev.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[][] array = {{1, 2}, {3, 4}, {5, 6}};

        Matrix a = new Matrix(new double[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}});
        Matrix b = new Matrix(new double[][]{{1, 1}, {2, 2}, {3, 3}});
        Vector v1 = new Vector(new double[]{1, 1, 1});

        System.out.println(a.multiplyVector(v1));
        System.out.println(Matrix.multiplyMatrices(a, b));
        System.out.println(a);
        System.out.println(b);
        System.out.println(v1);

    }
}
