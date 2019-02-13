package ru.academit.mitiukliaev.shape;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return height * width;
    }

    public double getPerimeter() {
        return (double) 2 * (width + height);
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
