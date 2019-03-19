package ru.academit.mitiukliaev.matrix;

import ru.academit.mitiukliaev.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] lines;

    //Конструкторы не должны позволять создать матрицу размера 0 - DONE
    public Matrix(int linesCount, int columnsCount) {
        if (linesCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException("Size must be positive!");
        }

        this.lines = new Vector[linesCount];
        for (int i = 0; i < linesCount; i++) {
            this.lines[i] = new Vector(columnsCount);
        }
    }

    //Второй конструктор работает неверно, т.к. там в массиве будут те же векторы - DONE
    public Matrix(Matrix source) {
        int i = 0;
        this.lines = new Vector[source.lines.length];
        for (Vector e : source.lines) {
            this.lines[i] = new Vector(e);
            ++i;
        }
    }

    //Надо учесть, что в конструкторе от двумерного массива может быть разная длина 2 измерения. - DONE
    public Matrix(double[]... source) {
        if (source.length == 0) {
            throw new IllegalArgumentException("Source is empty");
        }

        int linesCount = source.length;
        this.lines = new Vector[linesCount];
        for (int i = 0; i < linesCount; i++) {
            this.lines[i] = new Vector(source[i]);
        }
        this.setSize(linesCount, this.getColumnsCount());
    }

    //Надо учесть, что в конструкторе от двумерного массива может быть разная длина 2 измерения. - DONE
    public Matrix(Vector... source) {
        if (source.length == 0) {
            throw new IllegalArgumentException("Source is empty");
        }

        int linesCount = source.length;
        this.lines = new Vector[linesCount];
        for (int i = 0; i < linesCount; i++) {
            this.lines[i] = new Vector(source[i]);
        }
        this.setSize(linesCount, this.getColumnsCount());
    }

    public void setSize(int linesCount, int columnsCount) {
        if (linesCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException("Size must be positive!");
        }

        int oldLinesCount = this.getLinesCount();
        this.lines = Arrays.copyOf(this.lines, linesCount);

        for (int i = 0; i < linesCount; i++) {
            this.lines[i] = (i < oldLinesCount ? this.lines[i].setSize(columnsCount) : new Vector(columnsCount));
        }
    }

    public void setElement(int line, int column, double value) {
        if (line < 0 || line >= this.getLinesCount()) {
            throw new IllegalArgumentException("Line " + line + " is out of range");
        }
        if (column < 0 || line >= this.getColumnsCount()) {
            throw new IllegalArgumentException("Column " + column + " is out of range");
        }
        this.lines[line].setCoordinate(column, value);
    }

    //Транспонирование матрицы
    public Matrix transpose() {
        Matrix tmp = new Matrix(this.getColumnsCount(), this.getLinesCount());
        for (int i = 0; i < this.getColumnsCount(); i++) {
            tmp.setLine(i, this.getColumn(i));
        }
        return tmp;
    }

    //Получение размеров матрицы - количество строк
    public int getLinesCount() {
        return this.lines.length;
    }

    //Получение размеров матрицы - количество столбцов
    // TODO там не нужен цикл
    public int getColumnsCount() {
        int columnsCount = 0;
        for (Vector e : this.lines) {
            columnsCount = (columnsCount < e.getSize() ? e.getSize() : columnsCount);
        }
        return columnsCount;
    }

    //задание вектора-строки по индексу
    public void setLine(int index, Vector source) {
        if (index < 0 || index >= this.getLinesCount()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }
        source.setSize(this.getColumnsCount());
        this.lines[index] = new Vector(source);
    }

    //получение вектора-строки по индексу
    public Vector getLine(int index) {
        if (index < 0 || index >= this.getLinesCount()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }
        return this.lines[index];
    }

    //получение вектора-столбца по индексу
    public Vector getColumn(int index) {
        if (index < 0 || index >= this.getColumnsCount()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range");
        }
        Vector column = new Vector(this.getLinesCount());
        int i = 0;
        for (Vector e : this.lines) {
            column.setCoordinate(i, e.getCoordinate(index));
            ++i;
        }
        return column;
    }

    //Умножение на скаляр
    public Matrix multiplyScalar(double value) {
        int linesCount = this.getLinesCount();
        for (int i = 0; i < linesCount; i++) {
            this.lines[i].multiplyScalar(value);
        }
        return this;
    }

    //умножение матрицы на вектор
    public Vector multiplyVector(Vector vector) {
        if (vector.getSize() != this.getColumnsCount()) {
            String message = "Size(V) = " + vector.getSize();
            message += "doesn't match to ColumnsCount(M) = ";
            message += String.valueOf(this.getColumnsCount());
            throw new IllegalArgumentException(message);
        }
        int i = 0;
        Vector result = new Vector(this.getLinesCount());
        for (Vector e : this.lines) {
            result.setCoordinate(i, Vector.productScalar(e, vector));
            ++i;
        }
        return result;
    }

    //Сложение матриц
    public void add(Matrix matrix) {
        if (matrix.getColumnsCount() != this.getColumnsCount() || matrix.getLinesCount() != this.getLinesCount()) {
            throw new IllegalArgumentException("Sizes dom't match");
        }
        int i = 0;
        for (Vector e : matrix.lines) {
            this.lines[i].add(e);
            ++i;
        }
    }

    //вычитание матриц
    public void subtract(Matrix matrix) {
        if (matrix.getColumnsCount() != this.getColumnsCount() || matrix.getLinesCount() != this.getLinesCount()) {
            throw new IllegalArgumentException("Sizes dom't match");
        }
        int i = 0;
        for (Vector e : matrix.lines) {
            this.lines[i].subtract(e);
            ++i;
        }
    }

    //TODO - Вычисление определителя матрицы. Если не квадратная - бросить исключение
    // public double getDeterminant() {
    // return
    // }

    public static Matrix addMatrices(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() || matrix1.getLinesCount() != matrix2.getLinesCount()) {
            throw new IllegalArgumentException("Sizes dom't match");
        }
        Matrix result = new Matrix(matrix1);
        result.add(matrix2);
        return result;
    }

    public static Matrix subtractMatrices(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() || matrix1.getLinesCount() != matrix2.getLinesCount()) {
            throw new IllegalArgumentException("Sizes dom't match");
        }
        Matrix result = new Matrix(matrix1);
        result.subtract(matrix2);
        return result;
    }

    public static Matrix multiplyMatrices(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getLinesCount()) {
            throw new IllegalArgumentException("Sizes dom't match");
        }
        Matrix result = new Matrix(matrix2.getColumnsCount(), matrix1.getLinesCount());
        Matrix tmp = matrix2.transpose();
        int i = 0;
        for (Vector e : tmp.lines) {
            result.setLine(i, matrix1.multiplyVector(e));
            ++i;
        }
        result = result.transpose();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Vector e : this.lines) {
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
        return Arrays.equals(this.lines, matrix.lines);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (Vector e : this.lines) {
            result = result * prime + e.hashCode();
        }
        return result;
    }
}
