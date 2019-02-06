package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range_1 = new Range(-5, 4);
        Range range_2 = new Range(-9, 5);

        Range rangeIntersection = range_1.getIntersection(range_2);
        System.out.println("Intersection");
        if (rangeIntersection == null) {
            System.out.println("Intersection is void");
        } else {
            System.out.println(rangeIntersection.getFrom());
            System.out.println(rangeIntersection.getTo());
        }

        Range[] rangeUnion = range_1.getUnion(range_2);
        for (int i = 0; i < rangeUnion.length; i++) {
            System.out.printf("Union part %d%n", i + 1);
            System.out.println(rangeUnion[i].getFrom());
            System.out.println(rangeUnion[i].getTo());
        }

        Range[] rangeDifference = range_1.getDifference(range_2);
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