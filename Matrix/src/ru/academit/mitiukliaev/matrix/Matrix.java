package ru.academit.mitiukliaev.matrix;

import ru.academit.mitiukliaev.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] rows;

    //Конструкторы не должны позволять создать матрицу размера 0 - DONE
    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IndexOutOfBoundsException("Size must be positive!");
        }

        this.rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            this.rows[i] = new Vector(columnsCount);
        }
    }

    public Matrix(Matrix source) {
        this.rows = new Vector[source.rows.length];
        int rowsCount = rows.length;
        for (int i = 0; i < rowsCount; i++) {
            this.rows[i] = new Vector(this.getRow(i));
            ++i;
        }
    }

    //Надо учесть, что в конструкторе от двумерного массива может быть разная длина 2 измерения. - DONE
    public Matrix(double[]... source) {
        if (source.length == 0) {
            throw new IllegalArgumentException("Input array is void, nothing to copy");
        }

        int rowsCount = source.length;
        if (rowsCount == 0) {
            return;
        }
        this.rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            this.rows[i] = new Vector(source[i]);
        }
        this.setSize(rowsCount, this.getColumnsCount());
    }

    // Надо учесть, что в конструкторе от двумерного массива может быть разная длина 2 измерения. - DONE
    // Конструктор от двумерного массива. Там надо чтобы ничего не создавалось если размер 0

    public Matrix(Vector... source) {
        // if (source.length == 0) {
        //    throw new IllegalArgumentException("Source is empty, nothing to copy");
        //}

        int rowsCount = source.length;
        if (rowsCount == 0) {
            return;
        }
        this.rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            this.rows[i] = new Vector(source[i]);
        }
        this.setSize(rowsCount, this.getColumnsCount());
    }

    public void setSize(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IndexOutOfBoundsException("Size must be positive!");
        }

        int oldRowsCount = this.getRowsCount();
        this.rows = Arrays.copyOf(this.rows, rowsCount);

        for (int i = 0; i < rowsCount; i++) {
            this.rows[i] = (i < oldRowsCount ? rows[i].setSize(columnsCount) : new Vector(columnsCount));
        }
    }

    public void setElement(int row, int column, double value) {
        if (row < 0 || row >= this.getRowsCount()) {
            throw new IndexOutOfBoundsException("Row " + row + " is out of range");
        }
        if (column < 0 || row >= this.getColumnsCount()) {
            throw new IndexOutOfBoundsException("Column " + column + " is out of range");
        }
        this.rows[row].setCoordinate(column, value);
    }

    //Транспонирование матрицы
    public void transpose() {
        Matrix tmp = new Matrix(rows);
        this.setSize(this.getColumnsCount(), this.getRowsCount());
        int newRowCount = tmp.getColumnsCount();
        for (int i = 0; i < newRowCount; i++) {
            this.setRow(i, tmp.getColumn(i));
        }
    }

    //Получение размеров матрицы - количество строк
    public int getRowsCount() {
        return this.rows.length;
    }

    //Получение размеров матрицы - количество столбцов
    public int getColumnsCount() {
        return rows[0].getSize();
    }

    //задание вектора-строки по индексу
    public void setRow(int index, Vector source) {
        if (index < 0 || index >= this.getRowsCount()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }
        if (source.getSize() != rows[index].getSize()) {
            throw new IllegalArgumentException("Size(V) = " + source.getSize() + " doesn't match to ColumnsCount(M) = " + rows[index].getSize());
        }
        this.rows[index] = new Vector(source);
    }

    //получение вектора-строки по индексу
    public Vector getRow(int index) {
        if (index < 0 || index >= this.getRowsCount()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }
        return this.rows[index];
    }

    //получение вектора-столбца по индексу
    public Vector getColumn(int index) {
        if (index < 0 || index >= this.getColumnsCount()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }
        Vector column = new Vector(this.getRowsCount());
        int rowsCount = rows.length;
        for (int i = 0; i < rowsCount; i++) {
            column.setCoordinate(i, this.rows[i].getCoordinate(index));
        }
        return column;
    }


    //Умножение на скаляр
    public Matrix multiplyScalar(double value) {
        //   int rowsCount = this.getRowsCount();
        //   for (int i = 0; i < rowsCount; i++) {
        //   this.rows[i].multiplyScalar(value);
        for (Vector e : rows) {
            e.multiplyScalar(value);
        }
        return this;
    }

    //умножение матрицы на вектор
    public Vector multiplyVector(Vector vector) {
        if (vector.getSize() != this.getColumnsCount()) {
            String message = "Size(V) = " + vector.getSize();
            message += " doesn't match to ColumnsCount(M) = ";
            message += String.valueOf(this.getColumnsCount());
            throw new IllegalArgumentException(message);
        }

        Vector result = new Vector(this.getRowsCount());
        int rowsCount = rows.length;
        for (int i = 0; i < rowsCount; i++) {
            result.setCoordinate(i, Vector.productScalar(this.rows[i], vector));
        }

        return result;
    }

    //Сложение матриц
    public void add(Matrix matrix) {
        if (matrix.getColumnsCount() != this.getColumnsCount() || matrix.getRowsCount() != this.getRowsCount()) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int rowsCount = matrix.rows.length;
        for (int i = 0; i < rowsCount; i++) {
            this.rows[i].add(matrix.rows[i]);
        }
    }

    //вычитание матриц
    public void subtract(Matrix matrix) {
        if (matrix.getColumnsCount() != this.getColumnsCount() || matrix.getRowsCount() != this.getRowsCount()) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int rowsCount = matrix.rows.length;
        for (int i = 0; i < rowsCount; i++) {
            this.rows[i].subtract(matrix.rows[i]);
        }
    }

    private Matrix getMinor(int index) {
        Matrix minor = new Matrix(this.rows);
        int size = this.rows.length;
        // System.arraycopy(this.rows, index + 1, minor.rows, index, size - index - 1);

        for (int i = index; i < size - 1; i++) {
            minor.rows[i] = minor.rows[i + 1];
        }

        minor.setSize((size - 1), (size - 1));
        return minor;
    }

    //Вычисление определителя матрицы. Если не квадратная - бросить исключение
    public double getDeterminant() {
        int size = this.getColumnsCount();
        if (size != this.getRowsCount()) {
            throw new IllegalArgumentException("ColumnsCount = " + size + " NOT EQUAL TO RowsCount = " + this.getRowsCount());
        }

        double det = 0;
        if (size == 1) {
            det = this.rows[0].getCoordinate(0);
        } else {
            if (size == 2) {
                det = this.rows[0].getCoordinate(0) * this.rows[1].getCoordinate(1);
                det -= this.rows[0].getCoordinate(1) * this.rows[1].getCoordinate(0);
            } else {
                for (int i = 1; i <= size; i++) {
                    Matrix minor = getMinor(i - 1);
                    det += Math.pow(-1, i + size) * this.rows[i - 1].getCoordinate((size - 1)) * minor.getDeterminant();
                }
            }
        }
        return det;
    }

    public static Matrix addMatrices(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() || matrix1.getRowsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        Matrix result = new Matrix(matrix1);
        result.add(matrix2);
        return result;
    }

    public static Matrix subtractMatrices(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() || matrix1.getRowsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        Matrix result = new Matrix(matrix1);
        result.subtract(matrix2);
        return result;
    }

    public static Matrix multiplyMatrices(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        Matrix result = new Matrix(matrix2.getColumnsCount(), matrix1.getRowsCount());
        Matrix tmp = matrix2;
        tmp.transpose();
        int rowsCount = tmp.rows.length;
        for (int i = 0; i < rowsCount; i++) {
            result.setRow(i, matrix1.multiplyVector(tmp.rows[i]));
        }
        result.transpose();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Vector e : this.rows) {
            sb.append(e.toString());
        }
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
        Matrix matrix = (Matrix) o;
        return Arrays.equals(this.rows, matrix.rows);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rows);
    }
}
