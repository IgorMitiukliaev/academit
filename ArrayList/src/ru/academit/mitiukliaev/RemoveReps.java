package ru.academit.mitiukliaev;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveReps {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 4, 6, 8, 7, 9, 10));
        ArrayList<Integer> filteredList = new ArrayList<>();
        for (Integer e : list) {
            if (filteredList.indexOf(e) == -1) {
                filteredList.add(e);
            }
        }
        System.out.println(filteredList);
    }
}