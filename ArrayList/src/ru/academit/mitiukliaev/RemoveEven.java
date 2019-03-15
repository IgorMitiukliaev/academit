package ru.academit.mitiukliaev;


import java.util.ArrayList;
import java.util.Arrays;

public class RemoveEven {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(24, 22, 3, 4, 5, 6, 22, 8, 9, 2, 4, 6, 8, 7, 9, 3));
        int i = 0;
        while (i < list.size()) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            } else {
                ++i;
            }
        }
        System.out.println(list);
    }
}
