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
        if (coordinates.length == 0) {
            throw new IllegalArgumentException("Input array is void");
        }
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

    public Vector setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive!");
        }
        if (size == this.getSize()) {
            return this;
        } else {
            this.coordinates = Arrays.copyOf(this.coordinates, size);
            return this;
        }
    }

    public double getCoordinate(int i) {
        if (i < 0 || (i >= this.getSize())) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return this.coordinates[i];
    }

    public void setCoordinate(int i, double value) {
        if (i < 0 || i >= this.getSize()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        this.coordinates[i] = value;
    }

    public Vector add(Vector vector) {
        int sizeThis = this.getSize();
        int sizeVector = vector.getSize();
        if (sizeThis >= sizeVector) {
            for (int i = 0; i < sizeThis; i++) {
                this.coordinates[i] += (i < sizeVector ? vector.coordinates[i] : 0);
            }
        } else {
            double[] newCoordinates = new double[sizeVector];
            for (int i = 0; i < sizeVector; i++) {
                newCoordinates[i] = (i < sizeThis ? this.coordinates[i] : 0) + vector.coordinates[i];
            }
            this.coordinates = Arrays.copyOf(newCoordinates, sizeVector);
        }
        return this;
    }

    public Vector subtract(Vector vector) {
        int sizeThis = this.getSize();
        int sizeVector = vector.getSize();
        if (sizeThis >= sizeVector) {
            for (int i = 0; i < sizeThis; i++) {
                this.coordinates[i] -= (i < sizeVector ? vector.coordinates[i] : 0);
            }
        } else {
            double[] newCoordinates = new double[sizeVector];
            for (int i = 0; i < sizeVector; i++) {
                newCoordinates[i] = (i < sizeThis ? this.coordinates[i] : 0) - vector.coordinates[i];
            }
            this.coordinates = Arrays.copyOf(newCoordinates, sizeVector);
        }
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
        for (double e : this.coordinates) {
            length += e * e;
        }
        return Math.sqrt(length);
    }


    public static Vector addVector(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);
        return result.add(vector2);
    }

    public static Vector subtractVector(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);
        return result.subtract(vector2);
    }

    public static double productScalar(Vector vector1, Vector vector2) {
        int size = Math.min(vector1.getSize(), vector2.getSize());
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += vector1.coordinates[i] * vector2.coordinates[i];
        }
        return result;
    }

    @Override
    public String toString() {
        if (this.getSize() <= 0) {
            throw new IllegalArgumentException("null value encountered!");
        }
        String string = Arrays.toString(this.coordinates);
        string = string.replace("[", "{ ");
        string = string.replace("]", " }");
        return string;
        /*
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < coordinates.length - 1; i++) {
            sb.append(this.coordinates[i]);
            sb.append(", ");
        }
        sb.append(this.coordinates[coordinates.length - 1]);
        sb.append("}");
        return sb.toString();
        */
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