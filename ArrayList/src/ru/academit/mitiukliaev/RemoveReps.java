package ru.academit.mitiukliaev;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveReps {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 4, 6, 8, 7, 9, 10));
        ArrayList<Integer> filteredList = new ArrayList<>();
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            if (list.indexOf(list.get(i)) == i) {
                filteredList.add(list.get(i));
            }
        }
        System.out.println(filteredList);
    }
}