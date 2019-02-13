package ru.academit.mitiukliaev.shape;

public class Triangle implements Shape {
    private double x1, y1, x2, y2, x3, y3;
    private double minX, maxX, minY, maxY;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public double getWidth() {
        maxX = Math.max(Math.max(x1, x2), x3);
        minX = Math.min(Math.min(x1, x2), x3);
        return maxX - minX;
    }

    public double getHeight() {
        maxY = Math.max(Math.max(y1, y2), y3);
        minY = Math.min(Math.min(y1, y2), y3);
        return maxY - minY;
    }

    public double getArea() {
        return Math.abs(((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2);
    }

    public double getPerimeter() {
        double sideLength13 = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
        double sideLength12 = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double sideLength32 = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
        return sideLength13 + sideLength12 + sideLength32;
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
