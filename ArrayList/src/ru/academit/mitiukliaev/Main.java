package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.arraylist.MyArrayList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myList = new MyArrayList<>(0);
        LinkedList<String> someCollection = new LinkedList();
        System.out.println("myList = " + myList);

        someCollection.add("s1");
        someCollection.add("s2");
        someCollection.add(null);
        System.out.println("someCollection = " + someCollection);
        MyArrayList<String> myList2 = new MyArrayList<>(someCollection);
        System.out.println("myList2 = " + myList2);
        MyArrayList<String> myList3 = new MyArrayList<>(someCollection);

        for (int i = 0; i < 10; i++) {
            myList.add(i, Integer.toString(i * 2));
        }
        System.out.println("myList = " + myList);
        System.out.println(myList2.equals(myList3));
        myList.addAll(someCollection);
        System.out.println("myList.addAll(someCollection) = " + myList);
        System.out.println("myList.remove(4) = " + myList.remove(4));
        System.out.println("myList = " + myList);

        System.out.println("myList.removeAll(someCollection) = " + myList.removeAll(someCollection));
        System.out.println("myList = " + myList);

        for (int i = 5; i < 10; i++) {
            myList.add(i, Integer.toString(i * 5));
            System.out.println("myList = " + myList);
        }
        System.out.println();
        System.out.println("myList = " + myList);

        System.out.println(myList.lastIndexOf("16"));
        myList.ensureCapacity(50);
        myList.trimToSize();

        String a[] = new String[30];
        myList2.toArray(a);
    }
}
