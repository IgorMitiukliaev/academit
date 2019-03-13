package ru.academit.mitiukliaev.matrix;

import ru.academit.mitiukliaev.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] matrix;

    public Matrix(int height, int length) {
        this.matrix = new Vector[height];
        for (int i = 0; i < height; i++) {
            this.matrix[i] = new Vector(length);
        }
    }

    public Matrix(Matrix source) {
        this.matrix = Arrays.copyOf(source.matrix, source.getHeight());
    }

    public Matrix(double[]... source) {
        int height = source.length;
        this.matrix = new Vector[height];
        for (int i = 0; i < height; i++) {
            this.matrix[i] = new Vector(source[i]);
        }
    }

    public Matrix(Vector... source) {
        int height = source.length;
        this.matrix = new Vector[height];
        for (int i = 0; i < height; i++) {
            this.matrix[i] = new Vector(source[i]);
        }
    }

    public int getHeight() {
        return this.matrix.length;
    }

    public int getWidth() {
        int maxWidth = 0;
        for (Vector e : this.matrix
        ) {
            maxWidth = maxWidth > e.getSize() ? maxWidth : e.getSize();
        }
        return maxWidth;
    }

    public void setVector(int index, double... source) {
        if (!(source.length == this.getWidth())) {
            throw new IllegalArgumentException("Source size = " + source.length + " / this.size = " + this.getWidth());
        }
        if (index < 0 || index >= this.getWidth()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }
        this.matrix[index] = this.matrix[index].multiplyScalar(0).add(new Vector(source));
        return;
    }

    public Vector getVector(int index) {
        if (index < 0 || index >= this.getWidth()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }
        return this.matrix[index];
    }


    public Vector getColumn(int index) {
        if (index < 0 || index >= this.getHeight()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }
        Vector column = new Vector(this.getHeight());
        int i = 0;
        for (Vector e : this.matrix
        ) {
            column.setCoordinate(i, this.matrix[i].getCoordinate(index));
            ++i;
        }
        return column;
    }

    /*
            public Matrix transpose() {
                return this;
            }

            public Matrix miltiplyScalar(double value) {
                return this;
            }

            public Matrix miltiplyVector(Vector vector) {
                return this;
            }

            public Matrix add(Matrix matrix) {
                return this;
            }

            public Matrix subtract(Matrix matrix) {
                return this;
            }

            public double getDeterminant() {
                return
            }
*/
    @Override
    public String toString() {
        return Arrays.toString(this.matrix);
    }

    /*
                @Override
                public boolean equals(Object o) {

                }

                @Override
                public int hashCode() {

                }

*/

}
