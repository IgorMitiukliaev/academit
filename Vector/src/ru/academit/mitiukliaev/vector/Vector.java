package ru.academit.mitiukliaev.vector;

import java.util.Arrays;

public class Vector {
    private double[] vectorArray;

    public Vector(int dimension) {
        vectorArray = new double[dimension];
    }

    public Vector(Vector vector2) {
        int dimension2 = vector2.getSize();
        vectorArray = new double[dimension2];
        for (int i = 0; i < vector2.getSize(); i++) {
            vectorArray[i] = vector2.getCoordinate(i);
        }
    }

    public Vector(double... coordinates) {
        vectorArray = Arrays.copyOf(coordinates, coordinates.length);
    }

    public Vector(int dimension, double... coordinates) {
        vectorArray = Arrays.copyOf(coordinates, dimension);
    }

    public int getSize() {
        return vectorArray.length;
    }

    public double getCoordinate(int i) {
        return vectorArray[i];
    }

    public void setCoordinate(int i, double value) {
        this.vectorArray[i] = value;
        return;
    }

    public double[] getArrayCoordinates(int arraySize) {
        double[] array = new double[arraySize];
        int n = Math.min(arraySize, this.getSize());
        for (int i = 0; i < n; i++) {
            array[i] = this.getCoordinate(i);
        }
        return array;
    }

    public Vector add(Vector vector) {
        int dimension = Math.min(this.getSize(), vector.getSize());
        for (int i = 0; i < dimension; i++) {
            this.vectorArray[i] += vector.getCoordinate(i);
        }
        return this;
    }

    public Vector subtract(Vector vector) {
        int dimension = Math.min(this.getSize(), vector.getSize());
        for (int i = 0; i < dimension; i++) {
            this.vectorArray[i] -= vector.getCoordinate(i);
        }
        return this;
    }

    public Vector multiplyScalar(double value) {
        for (int i = 0; i < this.getSize(); i++) {
            this.vectorArray[i] *= value;
        }
        return this;
    }

    public Vector reverse() {
        for (int i = 0; i < this.getSize(); i++) {
            this.vectorArray[i] *= -1;
        }
        return this;
    }

    public double getLength() {
        double length = 0;
        for (int i = 0; i < this.getSize(); i++) {
            length += this.vectorArray[i] * this.vectorArray[i];
        }
        return length;
    }

    public static Vector addVector(Vector vector1, Vector vector2) {
        int dimension = Math.max(vector1.getSize(), vector2.getSize());
        double[] vectorA = vector1.getArrayCoordinates(dimension);
        double[] vectorB = vector2.getArrayCoordinates(dimension);
        double[] result = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            result[i] = vectorA[i] + vectorB[i];
        }
        return new Vector(result);
    }

    public static Vector subtractVector(Vector vector1, Vector vector2) {
        int dimension = Math.max(vector1.getSize(), vector2.getSize());
        double[] vectorA = vector1.getArrayCoordinates(dimension);
        double[] vectorB = vector2.getArrayCoordinates(dimension);
        double[] result = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            result[i] = vectorA[i] - vectorB[i];
        }
        return new Vector(result);
    }

    public static double multiplyVector(Vector vector1, Vector vector2) {
        int dimension = Math.max(vector1.getSize(), vector2.getSize());
        double[] vectorA = vector1.getArrayCoordinates(dimension);
        double[] vectorB = vector2.getArrayCoordinates(dimension);
        double result = 0;
        for (int i = 0; i < dimension; i++) {
            result += vectorA[i] - vectorB[i];
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < vectorArray.length - 1; i++) {
            sb.append(this.vectorArray[i]);
            sb.append(", ");
        }
        sb.append(this.vectorArray[vectorArray.length - 1]);
        sb.append("}");
        return sb.toString();
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
        double[] vectorThis = this.getArrayCoordinates(this.getSize());
        double[] vectorThat = vector.getArrayCoordinates(vector.getSize());
        return Arrays.equals(vectorThis, vectorThat);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.vectorArray);
    }
}