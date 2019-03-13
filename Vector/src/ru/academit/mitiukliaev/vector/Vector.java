package ru.academit.mitiukliaev.vector;

import java.util.Arrays;

public class Vector {
    private double[] coordinates;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive!");
        }
        this.coordinates = new double[size];
    }

    public Vector(Vector source) {
        int size = source.getSize();
        this.coordinates = Arrays.copyOf(source.coordinates, size);
    }

    public Vector(double... coordinates) {
        this.coordinates = Arrays.copyOf(coordinates, coordinates.length);
    }

    public Vector(int size, double... coordinates) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive!");
        }
        this.coordinates = Arrays.copyOf(coordinates, size);
    }

    public int getSize() {
        return this.coordinates.length;
    }

    public double getCoordinate(int i) {
        try {
            if (i < 0 || i >= this.getSize()) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
            return this.coordinates[i];
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    public void setCoordinate(int i, double value) {
        try {
            if (i < 0 || i >= this.getSize()) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
            this.coordinates[i] = value;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

    }

    public Vector add(Vector vector) {
        int sizeThis = this.getSize();
        int sizeVector = vector.getSize();
        int size = Math.max(this.getSize(), vector.getSize());
        double[] newCoordinates = new double[size];
        for (int i = 0; i < size; i++) {
            newCoordinates[i] = (i < sizeThis ? this.coordinates[i] : 0) + (i < sizeVector ? vector.coordinates[i] : 0);
        }
        this.coordinates = Arrays.copyOf(newCoordinates, size);
        return this;
    }

    public Vector subtract(Vector vector) {
        int sizeThis = this.getSize();
        int sizeVector = vector.getSize();
        int size = Math.max(this.getSize(), vector.getSize());
        double[] newCoordinates = new double[size];
        for (int i = 0; i < size; i++) {
            newCoordinates[i] = (i < sizeThis ? this.coordinates[i] : 0) - (i < sizeVector ? vector.coordinates[i] : 0);
        }
        this.coordinates = Arrays.copyOf(newCoordinates, size);
        return this;
    }

    public Vector multiplyScalar(double value) {
        for (int i = 0; i < this.getSize(); i++) {
            this.coordinates[i] *= value;
        }
        return this;
    }

    public Vector reverse() {
        this.multiplyScalar(-1);
        return this;
    }

    public double getLength() {
        double length = 0;
        for (double e : coordinates) {
            length += e * e;
        }
        return Math.sqrt(length);
    }

    /*
        public static Vector addVector(Vector vector1, Vector vector2) {
            return vector1.add(vector2);
        }
    */
    public static Vector subtractVector(Vector vector1, Vector vector2) {
        return vector1.subtract(vector2);
    }

    public static double multiplyVector(Vector vector1, Vector vector2) {
        int size = Math.min(vector1.getSize(), vector2.getSize());
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += vector1.coordinates[i] * vector2.coordinates[i];
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
            for (int i = 0; i < coordinates.length - 1; i++) {
                sb.append(this.coordinates[i]);
                sb.append(", ");
            }
            sb.append(this.coordinates[coordinates.length - 1]);
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
        return Arrays.equals(this.coordinates, (vector.coordinates));
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.coordinates);
    }
}