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

    public Range getIntersection(Range range) {
        double fromIntersection = Math.max(from, range.from);
        double toIntersection = Math.min(to, range.to);
        if (fromIntersection < toIntersection) {
            return new Range(fromIntersection, toIntersection);
        } else
            return null;
    }

    public Range[] getUnion(Range range) {
        if (range.from > to) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        if (range.to < from) {
            return new Range[]{new Range(range.from, range.to), new Range(from, to)};
        }

        double fromUnion = Math.min(from, range.from);
        double toUnion = Math.max(to, range.to);
        Range rangeUnion = new Range(fromUnion, toUnion);
        return new Range[]{rangeUnion};
    }

    public Range[] getDifference(Range range) {
        if (range.from > to || range.to < from) {
            return new Range[]{new Range(from, to)};
        }

        if (from < range.from && to > range.to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        if (from >= range.from && to <= range.to) {
            return new Range[]{};
        }

        double fromDifference;
        double toDifference;
        if (from < range.from) {
            fromDifference = from;
            toDifference = range.from;
        } else {
            fromDifference = range.to;
            toDifference = to;
        }
        return new Range[]{new Range(fromDifference, toDifference)};
    }
}

