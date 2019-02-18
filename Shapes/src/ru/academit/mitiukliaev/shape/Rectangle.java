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
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName())
                .append(" (")
                .append("W=" + this.width + ", ")
                .append("H=" + this.height)
                .append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object shape) {
        if (shape == this) {
            return true;
        }
        if (shape == null || shape.getClass() != this.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) shape;
        return height == rectangle.height && width == rectangle.width;
    }

    @Override
    public int hashCode(){
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);
        return hash;
    }
}
