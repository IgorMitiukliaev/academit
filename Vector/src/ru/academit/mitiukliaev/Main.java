package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.vector.*;

public class Main {
    public static void main(String[] args) {
        double[] a = new double[]{1, 2, 3, 4, 5};

        Vector vector0 = new Vector(1);
        System.out.println("vector0 = " + vector0);
        System.out.println();

        Vector vector1 = new Vector(10);

        Vector vector2 = new Vector(vector1);
        vector1.setCoordinate(7, 10);

        System.out.println("vector1 = " + vector1);
        System.out.println("vector2 = " + vector2);
        System.out.println();

        double[] b = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Vector vector3 = new Vector(10, b);
        Vector vector10 = new Vector(5, b);

        System.out.println("vector3 = " + vector3);
        System.out.println("vector10 = " + vector10);
        System.out.println();

        Vector vector4 = new Vector(20, a);
        System.out.println("vector4 = " + vector4);

        System.out.println("vector3 + vector4 = " + vector3.add(vector4));
        System.out.println("vector3 = " + vector3);
  /*      System.out.println("vector3 - vector4 =  " + subtractVector(vector3, vector4));
        System.out.println("vector3 * 2 = " + vector3.multiplyScalar(2));
        System.out.println("reversed result = " + vector3.reverse());
        System.out.println("vector4 length = " + vector4.getLength());

        System.out.println("(vector2 = vector1) = " + vector2.equals(vector1));

        System.out.println(addVector(vector3, vector4));
        System.out.println(multiplyVector(vector3, vector4));
*/
    }
}