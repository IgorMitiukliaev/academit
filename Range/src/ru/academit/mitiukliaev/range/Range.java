package ru.academit.mitiukliaev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public double getLength() {
        return (to - from);
    }

    public boolean isInside(double x) {
        return (x >= this.from && x <= this.to);
    }

    public Range getIntersection(Range range_1, Range range_2) {
        if (range_2.getFrom() <= range_1.getTo() || range_1.getFrom() <= range_2.getTo()) {
            {
                double from = Math.max(range_1.getFrom(), range_2.getFrom());
                double to = Math.min(range_1.getTo(), range_2.getTo());
                if (from <= to) {
                    return new Range(from, to);
                }
            }
        }
        return null;
    }

    public Range[] getUnion(Range range_1, Range range_2) {
        if (getIntersection(range_1, range_2) == null) {
            return new Range[]{range_1, range_2};
        }
        double from = Math.min(range_1.getFrom(), range_2.getFrom());
        double to = Math.max(range_1.getTo(), range_2.getTo());
        Range range = new Range(from, to);
        return new Range[]{range};
    }

    public Range[] getDifference(Range range_1, Range range_2) {
        if (getIntersection(range_1, range_2) == null) {
            return new Range[]{range_1};
        }
        if (range_1.getFrom() < range_2.getFrom() && range_1.getTo() > range_2.getTo()) {
            Range range_A = new Range(range_1.getFrom(), range_2.getFrom());
            Range range_B = new Range(range_2.getTo(), range_1.getTo());
            return new Range[]{range_A, range_B};
        }
        double from;
        double to;
        if (range_1.getFrom() < range_2.getFrom()) {
            from = range_1.getFrom();
            to = range_2.getFrom();
        } else {
            from = range_2.getTo();
            to = range_1.getTo();
        }
        Range range = new Range(from, to);
        return new Range[]{range};
    }
}

