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
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName())
                .append(" (")
                .append("W=" + this.sideLength + ", ")
                .append("H=" + this.sideLength)
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
        Square square = (Square) shape;
        return sideLength == square.sideLength;
    }

    @Override
    public int hashCode(){
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(sideLength);
        return hash;
    }
}
