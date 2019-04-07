package ru.academit.mitiukliaev.list;

import java.util.Objects;

public class LinkedList<T> {
    private Node<T> head;
    private int count;

    public LinkedList() {
        this.head = null;
        count = 0;
    }

    public LinkedList(T data) {
        this.head = new Node<>(data);
        count = 1;
    }

    //поиск нужного элемента
    private Node<T> getNode(int index) {
        Node<T> currentNode = head;
        int i = 0;
        while (i < index) {
            currentNode = currentNode.getNext();
            ++i;
        }
        return currentNode;
    }

    //вставка элемента в начало
    public void insertValue(T value) {
        head = new Node<>(value, this.head);
        ++count;
    }

    //получение размера списка
    public int getCount() {
        return count;
    }

    //получение значения первого элемента
    public T getHeadValue() {
        if (head == null) {
// Thrown when an application attempts to use null in a case where an object is required, including accessing or modifying the field of a null object
            throw new NullPointerException("The list is empty");
        }
        return head.getData();
    }

    //установка значения первого элемента
    public void setHeadValue(T value) {
        if (head == null) {
            throw new NullPointerException("The list is empty");
        }
        head.setData(value);
    }

    //получение значения по указанному индексу.
    public T get(int index) {
        if (index >= this.getCount() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, LinkedList length is " + this.getCount());
        }
        return getNode(index).getData();
    }

    //изменение значения по указанному индексу.
    public T set(int index, T value) {
        if (index >= this.getCount() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, LinkedList length is " + this.getCount());
        }
        return getNode(index).setData(value);
    }

    //удаление элемента по индексу, пусть выдает значение элемента
    public T deleteIndex(int index) {
        if (head == null) {
            throw new IllegalArgumentException("The list is empty, nothing to delete");
        }
        if (index >= this.getCount() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, LinkedList length is " + this.getCount());
        }
        if (index == 0) {
            Node<T> tmp = head;
            head = head.getNext();
            --count;
            return tmp.getData();
        }

        Node<T> previousNode = getNode(index - 1);
        Node<T> tmp = previousNode.getNext();
        previousNode.setNext(tmp.getNext());
        --count;
        return tmp.getData();
    }

    //вставка элемента по индексу
    public void insertIndexValue(int index, T value) {
        if (index > this.getCount() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, LinkedList length is " + this.getCount());
        }

        if (index == 0) {
            insertValue(value);
            return;
        }

        Node<T> previousNode = getNode(index - 1);
        Node<T> newNode = new Node<>(value);
        newNode.setNext(previousNode.getNext());
        previousNode.setNext(newNode);
        ++count;
    }

    //удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean deleteValue(T value) {
        if (head == null) {
            return false;
        }

        if (Objects.equals(head.getData(), value)) {
            head = head.getNext();
            --count;
            return true;
        }

        Node<T> currentNode = head;
        while (!Objects.equals(currentNode.getNext(), null)) {
            //    boolean check = (value == null && currentNode.getNext().getData() == null) || currentNode.getNext().getData().equals(value);
            boolean check = Objects.equals(value, currentNode.getNext().getData());
            if (check) {
                currentNode.setNext(currentNode.getNext() == null ? null : currentNode.getNext().getNext());
                --count;
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    //удаление первого элемента, пусть выдает значение элемента
    public T deleteHead() {
        if (head == null) {
            throw new IllegalArgumentException("The list is empty, nothing to delete");
        }
        T tmp = head.getData();
        head = head.getNext();
        --count;
        return tmp;
    }

    //разворот списка за линейное время
    public void reverse() {
        if (head == null || head.getNext() == null) {
            return;
        }
        Node<T> previous = head.getNext();
        Node<T> current = previous.getNext();

        head.setNext(null);
        previous.setNext(head);

        while (current != null) {
            Node<T> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    //копирование списка
    public LinkedList<T> copy() {
        LinkedList<T> newList = new LinkedList<>();
        newList.count = this.getCount();
        if (this.head == null) {
            return newList;
        }

        Node<T> tempNode = this.head;
        Node<T> newListNode = new Node<>(tempNode.getData());
        newList.head = newListNode;
        if (tempNode.getNext() == null) {
            return newList;
        }

        while (tempNode.getNext() != null) {
            Node<T> newListNextNode = new Node<>(tempNode.getNext().getData());
            newListNode.setNext(newListNextNode);
            newListNode = newListNode.getNext();
            tempNode = tempNode.getNext();
        }
        return newList;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "()";
        }

        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = head;
        sb.append("(");
        sb.append("Length = ");
        sb.append(count);
        sb.append(" | ");
        sb.append(currentNode.getData());
        currentNode = currentNode.getNext();
        for (int i = 1; i < count; i++) {
            sb.append(", ");
            sb.append(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        sb.append(")");
        return sb.toString();
    }
}




