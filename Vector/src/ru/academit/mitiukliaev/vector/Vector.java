package ru.academit.mitiukliaev.vector;

public class Vector {
    private int dimension;
    private double[] vector;

    public Vector(int n) {
        this.dimension = n;
        vector = new double[this.dimension];
    }

    public Vector(Vector vector2) {
        this.dimension = vector2.getDimension();
        vector = new double[this.dimension];
        for (int i = 0; i < this.dimension; i++) {
            vector[i] = vector2.getCoordinate(i);
        }
    }

    public Vector(double... coordinates) {
        this.dimension = coordinates.length;
        vector = new double[this.dimension];
        for (int i = 0; i < this.dimension; i++) {
            vector[i] = coordinates[i];
        }
    }

    public Vector(int n, double[] coordinates) {
        this.dimension = n;
        this.vector = new double[this.dimension];
        int coordinatesDimension = coordinates.length;
        for (int i = 0; i < this.dimension; i++) {
            if (i < coordinatesDimension) {
                this.vector[i] = coordinates[i];
            } else {
                this.vector[i] = 0;
            }
        }
    }

    public int getDimension() {
        return this.dimension;
    }

    public double getCoordinate(int i) {
        return vector[i];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < this.dimension - 1; i++) {
            sb.append(this.vector[i] + ", ");
        }
        sb.append(this.vector[this.dimension - 1] + "}");
        return sb.toString();
    }
}
