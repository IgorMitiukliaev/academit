package ru.academit.mitiukliaev.matrix;

import ru.academit.mitiukliaev.vector.Vector;

public class Matrix extends Vector {
    private Vector[] matrix;

    public Matrix(int sizeMatrix, int sizeVector) {
        this.matrix = new Vector[sizeMatrix];
        for (int i = 0; i < sizeMatrix; i++) {
            this.matrix[i] = new Vector(sizeVector);
        }
    }

    public int getHeight() {
        return matrix.length;
    }

    public int getWidth() {
        return matrix[0].getSize();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < this.getHeight() - 1; i++) {
            sb.append(matrix[i].toString());
            sb.append(", ");
        }
        sb.append(matrix[this.getHeight() - 1].toString());
        sb.append("}");
        return sb.toString();
    }
}
