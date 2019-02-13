package ru.academit.mitiukliaev.shape;

public class Circle implements Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return (double) 2 * radius;
    }

    public double getHeight() {
        return (double) 2 * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return (double) 2 * Math.PI * radius;
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
