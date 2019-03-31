package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.list.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>("head");
        LinkedList<String> newList = list.copy();
        System.out.println(list);
        System.out.println(list.getIndexValue(0));
        System.out.println("list.getCount= " + list.getCount());
        System.out.println(newList);
        System.out.println("newList.getCount= " + newList.getCount());
        System.out.println();

        for (int i = 0; i <= 10; i++) {
            list.insertValue(String.valueOf(i));
        }
        System.out.println("0 inserted at index 0 " + list);
        System.out.println("list.getCount= " + list.getCount());

        list.insertIndexValue(list.getCount(), "new");
        System.out.println("new inserted at end " + list);

        list.setIndexValue(1, null);
        System.out.println("element @1 altered " + list);
        list.deleteValue(null);
        System.out.println("element @1 deleted " + list);
        System.out.println("newList remains = " + newList);
        System.out.println();

        int index = 1;
        list.insertIndexValue(index, null);
        System.out.println(list);
        System.out.println("deleteIndex(" + index + ") = " + list.deleteIndex(index));
        System.out.println(list);

        list.reverse();
        System.out.println("list reversed = " + list);
        newList.setIndexValue(0, "head again");
        System.out.println(newList);
    }
}
