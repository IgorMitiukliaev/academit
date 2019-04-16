package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.hashtable.MyHashTable;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        MyHashTable<String> myTable = new MyHashTable<>(16);
        for (i = 0; i < 20; i++) {
            /*if (i % 3 == 0) {
                myTable.add(null);
            }*/
            myTable.add(Integer.toString(i));
        }
/*
        for (i = 0; i < 22; i++) {
            System.out.println(myTable.contains(Integer.toString(i)));
        }
*/
        LinkedList<String> myList = new LinkedList<>();
        for (i = 0; i < 10; i++) {
            myList.add(Integer.toString(i));
        }
        System.out.println(myTable);
        System.out.println("myTable.containsAll(myList)= " + myTable.containsAll(myList));
        System.out.println("myTable.retainAll(myList) = " + myTable.retainAll(myList));
        System.out.println();
        System.out.println(myTable);


    }
}
