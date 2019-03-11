package ru.academit.mitiukliaev.vector;

import java.util.Arrays;

public class Vector {
    private double[] vectorCoordinates;


    public Vector(int size) {
        try {
            if (size <= 0) {
                throw new IllegalArgumentException("Size must be positive!");
            }
            vectorCoordinates = new double[size];
        } catch (IllegalArgumentException e) {
            vectorCoordinates = null;
        }
    }

    public Vector(Vector source) {
        int size = source.getSize();
        this.vectorCoordinates = new double[size];
        this.vectorCoordinates = Arrays.copyOf(source.vectorCoordinates, size);
    }

    public Vector(double... coordinates) {
        vectorCoordinates = Arrays.copyOf(coordinates, coordinates.length);
    }

    public Vector(int size, double... coordinates) {
        try {
            if (size <= 0) {
                throw new IllegalArgumentException("Size must be positive!");
            }
            vectorCoordinates = Arrays.copyOf(coordinates, size);
        } catch (IllegalArgumentException e) {
            vectorCoordinates = null;
        }
    }

    public int getSize() {
        try {
            if (!(this instanceof Vector)) {
                throw new ClassCastException("Not in class");
            }
            if (this.equals(null)) {
                throw new NullPointerException("Null value encountered!");
            }
            return vectorCoordinates.length;
        } catch (Throwable e) {
            System.out.println(e);
            return 0;
        }
    }


    public double getCoordinate(int i) {
        try {
            if (i < 0 || i >= this.getSize()) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
            return vectorCoordinates[i];
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }


    public void setCoordinate(int i, double value) {
        try {
            if (i < 0 || i >= this.getSize()) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
            this.vectorCoordinates[i] = value;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

    }

    public Vector add(Vector vector) {
        int sizeThis = this.getSize();
        int sizeVector = vector.getSize();
        int size = Math.max(this.getSize(), vector.getSize());
        Vector newVector = new Vector(size);
        for (int i = 0; i < size; i++) {
            newVector.vectorCoordinates[i] = (i < sizeThis ? this.vectorCoordinates[i] : 0) + (i < sizeVector ? vector.vectorCoordinates[i] : 0);
        }
        return newVector;
    }

    public Vector subtract(Vector vector) {
        int sizeThis = this.getSize();
        int sizeVector = vector.getSize();
        int size = Math.max(this.getSize(), vector.getSize());
        Vector newVector = new Vector(size);
        for (int i = 0; i < size; i++) {
            newVector.vectorCoordinates[i] = (i < sizeThis ? this.vectorCoordinates[i] : 0) - (i < sizeVector ? vector.vectorCoordinates[i] : 0);
        }
        return newVector;
    }

    public Vector multiplyScalar(double value) {
        for (int i = 0; i < this.getSize(); i++) {
            this.vectorCoordinates[i] *= value;
        }
        return this;
    }

    public Vector reverse() {
        this.multiplyScalar(-1);
        return this;
    }

    public double getLength() {
        double length = 0;
        for (double e : vectorCoordinates) {
            length += e * e;
        }
        return Math.sqrt(length);
    }

    public static Vector addVector(Vector vector1, Vector vector2) {
        return vector1.add(vector2);
    }

    public static Vector subtractVector(Vector vector1, Vector vector2) {
        return vector1.subtract(vector2);
    }

    public static double multiplyVector(Vector vector1, Vector vector2) {
        int size = Math.min(vector1.getSize(), vector2.getSize());
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += vector1.vectorCoordinates[i] * vector2.vectorCoordinates[i];
        }
        return result;
    }

    @Override
    public String toString() {
        try {
            if (this.getSize() <= 0) {
                throw new IllegalArgumentException("null value encountered!");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (int i = 0; i < vectorCoordinates.length - 1; i++) {
                sb.append(this.vectorCoordinates[i]);
                sb.append(", ");
            }
            sb.append(this.vectorCoordinates[vectorCoordinates.length - 1]);
            sb.append("}");
            return sb.toString();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Vector vector = (Vector) o;
        return Arrays.equals(this.vectorCoordinates, (vector.vectorCoordinates));
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.vectorCoordinates);
    }
}