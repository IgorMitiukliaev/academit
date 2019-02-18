package ru.academit.mitiukliaev.shape;

public class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    private double sideLength(double x1, double x2, double y1, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    public double getArea() {
        return Math.abs(((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2);
    }

    public double getPerimeter() {
        return sideLength(x1, x3, y1, y3) + sideLength(x1, x2, y1, y2) + sideLength(x2, x3, y2, y3);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName())
                .append(" (")
                .append("X1=" + this.x1 + ", " + "Y1=" + this.y1 + ", ")
                .append("X2=" + this.x2 + ", " + "Y2=" + this.y2 + ", ")
                .append("X3=" + this.x3 + ", " + "Y3=" + this.y3)
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
        Triangle triangle = (Triangle) shape;
        return x1 == triangle.x1 && x2 == triangle.x2 && x3 == triangle.x3 && y1 == triangle.y1 && y2 == triangle.y2 && y3 == triangle.y3;
    }

    @Override
    public int hashCode(){
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
    }
}
