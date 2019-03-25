package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.list.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        LinkedList<String> newList = list.copy();
        System.out.println(list);
        System.out.println("list.getCount= " + list.getCount());
        System.out.println(newList);
        System.out.println("newList.getCount= " + newList.getCount());
        System.out.println();

        for (int i = 0; i <= 0; i++) {
            list.insertValue(String.valueOf(i));
        }
        System.out.println("0 inserted at index 0 " + list);
        System.out.println("list.getCount= " + list.getCount());

        list.insertIndexValue(list.getCount(), "new");
        System.out.println("new inserted at end " + list);

        list.setIndexValue(1, "altered element");
        System.out.println("element @1 altered " + list);
        list.deleteIndex(1);
        System.out.println("element @1 deleted " + list);
        System.out.println("newList remains = " + newList);
        System.out.println();

        int index = 1;
        list.insertIndexValue(index, null);
        System.out.println(list);
        System.out.println("deleteIndex(" + index + ") = " + list.deleteIndex(index));
        System.out.println(list);

        newList.reverse();
        System.out.println("newList reversed = " + newList);
        newList.setIndexValue(0, "head");
        System.out.println(newList.getIndexValue(0));
    }
}
