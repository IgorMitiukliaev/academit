package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.vector.*;

import static ru.academit.mitiukliaev.vector.Vector.*;

public class Main {
    public static void main(String[] args) {
        double[] a = new double[]{1, 2, 3, 4, 5};
        Vector vector1 = new Vector(a);
        Vector vector2 = new Vector(vector1);

        double[] b = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Vector vector3 = new Vector(10, b);

        System.out.println("vector3" + vector3);

        Vector vector4 = new Vector(7, a);
        System.out.println("vector4" + vector4);

        System.out.println("vector3 + vector4 = " + vector3.add(vector4));
        System.out.println("result - vector4 =  " + vector3.subtract(vector4));
        System.out.println("result * 2 = " + vector3.multiplyScalar(2));
        System.out.println("reversed " + vector3.reverse());
        System.out.println("vector4 length = " + vector4.getLength());

        System.out.println(vector2.equals(vector1));

        System.out.println(addVector(vector3, vector4));
        System.out.println(multiplyVector(vector3, vector4));

    }
}