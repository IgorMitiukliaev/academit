package ru.academit.mitiukliaev.shape;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getWidth() {
        return sideLength;
    }

    public double getHeight() {
        return sideLength;
    }

    public double getArea() {
        return sideLength * sideLength;
    }

    public double getPerimeter() {
        return (double) 4 * sideLength;
    }

    @Override
    public int compareTo(Shape shape) {
        double epsilon = 1e-5;
        if (this.getArea() - shape.getArea() > epsilon) {
            return 1;
        } else if (this.getArea() - shape.getArea() < epsilon) {
            return -1;
        } else {
            return 0;
        }
    }
}
