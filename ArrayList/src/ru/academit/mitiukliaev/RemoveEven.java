package ru.academit.mitiukliaev;


import java.util.ArrayList;
import java.util.Arrays;

public class RemoveEven {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 4, 6, 8, 7, 9, 3));
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            if (list.get(i) % 2 != 0) {
                list.add(list.get(i));
            }
        }
        list.subList(0, listSize).clear();
        System.out.println(list);
    }
}
