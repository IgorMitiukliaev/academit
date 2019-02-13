package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(-5, 4);
        Range range2 = new Range(4, 5);

        Range rangeIntersection = range1.getIntersection(range2);
        System.out.println("Intersection");
        if (rangeIntersection == null) {
            System.out.println("Intersection is void");
        } else {
            System.out.println(rangeIntersection.getFrom());
            System.out.println(rangeIntersection.getTo());
        }

        Range[] rangeUnion = range1.getUnion(range2);
        for (int i = 0; i < rangeUnion.length; i++) {
            System.out.printf("Union part %d%n", i + 1);
            System.out.println(rangeUnion[i].getFrom());
            System.out.println(rangeUnion[i].getTo());
        }

        Range[] rangeDifference = range1.getDifference(range2);
        if (rangeDifference == null) {
            System.out.println("Difference is void");
        } else {
            for (int i = 0; i < rangeDifference.length; i++) {
                System.out.printf("Difference part %d%n", i + 1);
                System.out.println(rangeDifference[i].getFrom());
                System.out.println(rangeDifference[i].getTo());
            }
        }
    }
}