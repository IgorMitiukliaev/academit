package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.hashtable.MyHashTable;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        MyHashTable<String> myTable = new MyHashTable<>(16);
        for (i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                myTable.add("i = " + i + "/j = " + j);
            }
        }

        for (String e : myTable) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println(myTable);
        System.out.println(myTable);

    }
}
