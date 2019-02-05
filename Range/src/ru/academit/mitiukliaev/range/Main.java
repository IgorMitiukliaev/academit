package ru.academit.mitiukliaev.range;

public class Main {
    public static void main(String[] args) {
        Range range_1 = new Range(-5, 4);
        Range range_2 = new Range(-3, -2);

        Range[] range_difference = range_1.getDifference(range_1, range_2);
        System.out.println(range_difference.length);
        for (int i=0; i<range_difference.length; i++){
            System.out.println(i);
            System.out.println(range_difference[i].getFrom());
            System.out.println(range_difference[i].getTo());
        }
    }
}