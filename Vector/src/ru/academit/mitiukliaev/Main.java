package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.vector.*;

import static ru.academit.mitiukliaev.vector.Vector.*;

public class Main {
    public static void main(String[] args) {
        double[] b = new double[]{1, 2, 3, 4, 5, 6, 7};

        Vector vector0 = new Vector(3);
        System.out.println("vector0 = " + vector0);

        Vector vector1 = new Vector(5);
        Vector vector2 = new Vector(vector1);
        vector1.setCoordinate(4, 10);

        System.out.println("vector1 = " + vector1);
        System.out.println("vector2 = " + vector2);
        System.out.println();

        Vector vector3 = new Vector(5, b);
        Vector vector4 = new Vector(10, b);
        Vector vector5 = new Vector(15, b);

        System.out.println("vector3 = " + vector3);
        System.out.println("vector4 = " + vector4);
        System.out.println("vector5 = " + vector5);
        System.out.println();

        vector3.setSize(7);
        System.out.println("vector3.setSize(7) = " + vector3);
        vector3.setSize(5);
        System.out.println("vector3.setSize(5) = " + vector3);
        System.out.println();

        System.out.println("vector3.add(vector4) = " + vector3.add(vector4));
        System.out.println("vector3 = " + vector3);
        System.out.println("vector4 = " + vector4);
        System.out.println();

        System.out.println("subtractVector(vector4,vector5) = " + subtractVector(vector4, vector5));
        System.out.println("vector4 = " + vector4);
        System.out.println("vector5 = " + vector5);
        System.out.println();

        vector3.multiplyScalar(2);
        System.out.println("vector3.multiplyScalar(2) = " + vector3);
        vector4.reverse();
        System.out.println("vector4reverse() = " + vector4);
        System.out.println();

        Vector vector6 = new Vector(new double[]{1, 1});
        System.out.println("vector6 = " + vector6);
        System.out.println("vector6 length = " + vector6.getLength());
        System.out.println("scalar product of (vector3, vector6) = " + productScalar(vector3, vector6));

        System.out.println("(vector2 = vector1) = " + vector2.equals(vector1));
        System.out.println("(vector2 = Vector(vector2)) = " + vector2.equals(new Vector(vector2)));
        Vector vector7 = new Vector(subtractVector(vector3, vector4));
        System.out.println();
        System.out.println("subtractVector(vector3, vector4) = " + vector7);
        System.out.println("И напоследок...");
        System.out.println("(vector3 = vector4 + (vector3 - vector4)) = " + vector3.setSize(vector7.getSize()).equals(addVector(vector4, vector7)));
    }
}