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

    public Range getIntersection(Range range2) {
        if (range2.from < to || from < range2.to) {
            double fromIntersection = Math.max(from, range2.from);
            double toIntersection = Math.min(to, range2.to);
            if (fromIntersection < toIntersection) {
                return new Range(fromIntersection, toIntersection);
            }
        }
        return null;
    }

    public Range[] getUnion(Range range2) {
        if (range2.from > to) {
            return new Range[]{new Range(from, to), new Range(range2.from, range2.to)};
        }

        if (range2.to < from) {
            return new Range[]{new Range(range2.from, range2.to), new Range(from, to)};
        }

        double fromUnion = Math.min(from, range2.from);
        double toUnion = Math.max(to, range2.to);
        Range range = new Range(fromUnion, toUnion);
        return new Range[]{range};
    }

    public Range[] getDifference(Range range2) {
        if (range2.from > to || range2.to < from) {
            return new Range[]{new Range(from, to)};
        }

        if (from < range2.from && to > range2.to) {
            return new Range[]{new Range(from, range2.from), new Range(range2.to, to)};
        }

        if (from >= range2.from && to <= range2.to) {
            return null;
        }

        double fromDifference;
        double toDifference;
        if (from < range2.from) {
            fromDifference = from;
            toDifference = range2.from;
        } else {
            fromDifference = range2.to;
            toDifference = to;
        }
        return new Range[]{new Range(fromDifference, toDifference)};
    }
}

