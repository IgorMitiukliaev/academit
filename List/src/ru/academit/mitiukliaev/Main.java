package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.list.LinkedList;
import ru.academit.mitiukliaev.list.Node;

public class Main {
    public static void main(String[] args) {
        String a = "1";
        Node<String> first = new Node<>(a);
        System.out.println(first);
        System.out.println(first.hashCode());

        LinkedList<String> list = new LinkedList<>(first);
        a = "2";
        list.appendValue(a);
        a = "3";
        list.appendValue(a);
        a = "4";
        list.appendValue(a);
        a = "5";
        list.appendValue(a);
        System.out.println("getCount = " + list.getCount());
        System.out.println(list);

        int index = 3;
        list.insertIndexValue(index, "new at index = " + index);
        System.out.println(list);
        System.out.println("deleteIndex(" + index + ") = " + list.deleteIndex(index));
        System.out.println(list);

        LinkedList<String> newList = list.copyList();

        list.setIndexValue(0, "altered element");
        System.out.println("list = " + list);
        System.out.println("newList = " + newList);
        newList.reverse();
        System.out.println("newList reversed = " + newList);
    }
}
