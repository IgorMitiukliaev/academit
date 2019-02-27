package ru.academit.mitiukliaev.shape;

public class Square implements Shape {
    private double sideLength;

    public Square(double SideLength) {
        this.sideLength = SideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        String name = this.getClass().getSimpleName() + " (";
        name += "W=" + this.sideLength + ", ";
        name += "H=" + this.sideLength + ")";
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return sideLength == square.sideLength;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(sideLength);
    }
}
