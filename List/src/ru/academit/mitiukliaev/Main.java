package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.list.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            list.insertValue(String.valueOf(i));
        }

        System.out.println("getCount = " + list.getCount());
        System.out.println(list);
        LinkedList<String> newList = list.copyList();
        list.setIndexValue(0, "altered element");
        System.out.println("list = " + list);
        System.out.println("newList = " + newList);

        int index = 5;
        list.insertIndexValue(index, "new at index = " + index);
        System.out.println(list);
        System.out.println("deleteIndex(" + index + ") = " + list.deleteIndex(index));
        System.out.println(list);


        newList.reverse();
        System.out.println("newList reversed = " + newList);
        newList.setIndexValue(0, "head");
        System.out.println(newList.getIndexValue(0));


    }
}
