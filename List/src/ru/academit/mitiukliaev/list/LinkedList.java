package ru.academit.mitiukliaev.list;

public class LinkedList<T> {
    private Node<T> head;
    private int count;

    public LinkedList() {
        this.head = null;
        count = 0;
    }

    public LinkedList(Node<T> data) {
        this.head = data;
        count = 1;
    }

    //вставка элемента в начало
    public void appendValue(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(this.head);
        head = newNode;
        ++count;
    }

    //получение размера списка
    public int getCount() {
        return count;
    }

    //получение значения первого элемента
    public T getHeadValue() {
        return head.getData();
    }

    //получение значения по указанному индексу.
    public T getIndexValue(int index) {
        if (index > this.getCount() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, LinkedList length is " + this.getCount());
        }
        int i = 0;
        Node<T> pointer = head;
        while (i < index) {
            pointer = pointer.getNext();
            ++i;
        }
        return pointer.getData();
    }

    //изменение значения по указанному индексу.
    public T setIndexValue(int index, T value) {
        if (value == null) {
            throw new NullPointerException("The value is null");
        }
        if (index > this.getCount() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, LinkedList length is " + this.getCount());
        }
        int i = 0;
        Node<T> pointer = head;
        while (i < index) {
            pointer = pointer.getNext();
            ++i;
        }
        return pointer.setData(value);
    }

    //удаление элемента по индексу, пусть выдает значение элемента
    public T deleteIndex(int index) {
        if (index > this.getCount() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, LinkedList length is " + this.getCount());
        }
        if (index == 0) {
            Node<T> tmp = head;
            head = head.getNext();
            --count;
            return tmp.getData();
        }

        int i = 0;
        Node<T> pointer = head;
        while (i < index-1) {
            pointer = pointer.getNext();
            ++i;
        }
        Node<T> tmp = pointer.getNext();
        pointer.setNext(tmp.getNext());
        --count;
        return tmp.getData();
    }

    //вставка элемента по индексу
    public void insertIndexValue(int index, T value) {
        if (value == null) {
            throw new NullPointerException("The value is null");
        }
        if (index > this.getCount() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, LinkedList length is " + this.getCount());
        }

        if (index == 0) {
            appendValue(value);
            return;
        }

        int i = 0;
        Node<T> pointer = head;
        while (i < index - 1) {
            pointer = pointer.getNext();
            ++i;
        }
        Node<T> newNode = new Node<>(value);
        newNode.setNext(pointer.getNext());
        pointer.setNext(newNode);
        ++count;
    }

    //удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean deleteValue(T value) {
        if (value == null) {
            throw new NullPointerException("The value is null");
        }

        if (head.getData().equals(value)) {
            head = head.getNext();
            --count;
            return true;
        }

        Node<T> pointer = head;
        while (pointer.getNext() != null) {
            if (pointer.getNext().getData().equals(value)) {
                pointer.setNext(pointer.getNext().getNext());
                --count;
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }

    //удаление первого элемента, пусть выдает значение элемента
    public T deleteHead() {
        T tmp = head.getData();
        head = head.getNext();
        --count;
        return tmp;
    }

    //разворот списка за линейное время
    public void reverse() {
        Node<T> first = head;
        Node<T> second = head.getNext();
        Node<T> third = second.getNext();

        first.setNext(null);
        second.setNext(first);

        Node<T> current = third;
        Node<T> previous = second;

        while (current != null) {
            Node<T> next = current.getNext();
            current.setNext(previous);

            previous = current;
            current = next;
        }
        head = previous;
    }

    //копирование списка
    public LinkedList<T> copyList() {
        LinkedList<T> newList = new LinkedList<>();

        Node<T> pointer = head;
        while (pointer != null) {
            newList.appendValue(pointer.getData());
            pointer = pointer.getNext();
        }
        newList.reverse();
        return newList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> pointer = head;
        sb.append("(");
        sb.append(pointer.getData());
        while (pointer.getNext() != null) {
            pointer = pointer.getNext();
            sb.append(", ");
            sb.append(pointer.getData());
        }
        sb.append(")");
        return sb.toString();
    }
}




