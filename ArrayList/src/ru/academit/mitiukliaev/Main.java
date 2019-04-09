package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.arraylist.MyArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> myList = new MyArrayList<>();
        List<String> someCollection = new MyArrayList<>(10);

        someCollection.add("s1");
        someCollection.add("s2");
        someCollection.add("s3");

        for (int i = 0; i < 10; i++) {
            myList.add(i, Integer.toString(i * 2));
        }
        System.out.println("myList.size() = " + myList.size());

        System.out.println("myList.addAll(someCollection) = " + myList.addAll(someCollection));
        System.out.println("myList = " + myList);
        System.out.println("myList.remove(4) = " + myList.remove(4));
        //System.out.println(myList.retainAll(someCollection));


        System.out.println("myList.removeAll(someCollection) = " + myList.removeAll(someCollection));
        System.out.println("myList = " + myList);

        for (int i = 5; i < 10; i++) {
            myList.add(i, Integer.toString(i * 5));
            System.out.println("myList = " + myList);
        }
        System.out.println();
        System.out.println("myList = " + myList);

        System.out.println(myList.lastIndexOf("16"));
        ((MyArrayList<String>) myList).trimToSize();
    }
}
