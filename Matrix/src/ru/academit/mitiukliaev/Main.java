package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.matrix.Matrix;
import ru.academit.mitiukliaev.vector.Vector;

import static ru.academit.mitiukliaev.matrix.Matrix.*;

public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(new double[][]{{1, 2, 3, 0.5}, {-1, 2, 0}, {-5, 2, 11, -2}, {1, 2}});
        //      Matrix a = new Matrix(new double[][]{{1, 2,}, {1, -2}});
        // Matrix a = new Matrix(new double[][]{{1, 2, 3}, {-1, 2, 0}, {1, 2}});
        System.out.println("a = " + a);
        System.out.println("det a = " + a.getDeterminant());

        a.multiplyScalar(2);
        System.out.println("a x 2 = " + a);
        System.out.println("det a = " + a.getDeterminant());
        a.transpose();
        System.out.println("(a)T = " + a);

        Matrix b = new Matrix(new double[][]{{1, 1, 1}, {1, 2, 3}, {3, 3}, {3, 3}});
        System.out.println("b = " + b);
        System.out.println("a x b = " + multiplyMatrices(a, b));
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        Vector v1 = new Vector(new double[]{1, 1, 1, 1});
        System.out.println("Vector v1 = " + v1);
        System.out.println("b.multiplyVector(v1) = " + b.multiplyVector(v1));
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println(new Matrix(new double[][]{{1}}));

        System.out.println();
        a = new Matrix(v1);
        System.out.println("a = " + a);
        a.transpose();
        System.out.println("(a)T = " + a);

    }
}
