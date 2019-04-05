package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.arraylist.MyArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> myList = new MyArrayList<>();
        List<String> someCollection = new MyArrayList<>(1);

        someCollection.add("1");

        for (int i = 1; i < myList.size(); i++) {
            myList.set(i, Integer.toString(i));
        }

        System.out.println(myList);
        System.out.println(someCollection);
        System.out.println(myList.retainAll(someCollection));
        System.out.println(myList);
    }
}
