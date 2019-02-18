package ru.academit.mitiukliaev.shape;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return 2 * radius;
    }

    public double getHeight() {
        return 2 * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (R=" + this.radius + ")";
    }

    @Override
    public boolean equals(Object shape) {
        if (shape == this) {
            return true;
        }
        if (shape == null || shape.getClass() != this.getClass()) {
            return false;
        }
        Circle circle = (Circle) shape;
        return radius == circle.radius;
    }

    @Override
    public int hashCode(){
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(radius);
        return hash;
    }
}
