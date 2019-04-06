package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.list.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        int index;

        System.out.println(list);
//        System.out.println(list.getIndexValue(0));
        System.out.println("list.getCount= " + list.getCount());

        System.out.println();

        for (int i = 1; i < 10; i++) {
            list.insertValue(String.valueOf(i));
            //        list.insertValue(null);
        }
        LinkedList<String> newList = list.copy();
        System.out.println("list = " + list);
        System.out.println("newList = " + newList);
        System.out.println("newList.getCount= " + newList.getCount());
        System.out.println();

        list.insertIndexValue(list.getCount(), null);
        System.out.println("null inserted at end " + list);

        index = 0;
        list.setIndexValue(index, null);
        System.out.println("element @" + index + " altered " + list);
        list.deleteValue(null);

        System.out.println("element @" + index + " deleted " + list);
        System.out.println("newList remains = " + newList);
        System.out.println();

        index = 1;
        list.insertIndexValue(index, null);
        System.out.println(list);
        System.out.println("deleteIndex(" + index + ") = " + list.deleteIndex(index));
        System.out.println(list);

        list.reverse();
        System.out.println("list reversed = " + list);

        System.out.println(newList);
    }
}
