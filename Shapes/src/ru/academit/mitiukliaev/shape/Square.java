package ru.academit.mitiukliaev.shape;

public class Square implements Shape {
    private double SideLength;

    public Square(double SideLength) {
        this.SideLength = SideLength;
    }

    public double getWidth() {
        return SideLength;
    }

    public double getHeight() {
        return SideLength;
    }

    public double getArea() {
        return SideLength * SideLength;
    }

    public double getPerimeter() {
        return 4 * SideLength;
    }

    @Override
    public String toString() {
        String name = this.getClass().getSimpleName() + " (";
        name += "W=" + this.SideLength + ", ";
        name += "H=" + this.SideLength + ")";
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
        return SideLength == square.SideLength;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(SideLength);
    }
}
