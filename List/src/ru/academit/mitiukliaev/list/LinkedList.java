package ru.academit.mitiukliaev.list;

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
    private Node<T> setCurrentNode(int index) {
        if (head != null) {
            Node<T> currentNode = head;
            int i = 0;
            while (i < index) {
                currentNode = currentNode.getNext();
                ++i;
            }
            return currentNode;
        }
        this.head = new Node<T>();
        Node<T> currentNode = head;
        return currentNode;
    }

    //вставка элемента в начало
    public void insertValue(T value) {
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
        return setCurrentNode(index).getData();
    }

    //изменение значения по указанному индексу.
    public T setIndexValue(int index, T value) {
        if (index > this.getCount() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, LinkedList length is " + this.getCount());
        }
        return setCurrentNode(index).setData(value);
    }

    //удаление элемента по индексу, пусть выдает значение элемента
    public T deleteIndex(int index) {
        if (head == null) {
            throw new IllegalArgumentException("The list is void, nothing to delete");
        }
        if (index > this.getCount() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of range, LinkedList length is " + this.getCount());
        }
        if (index == 0) {
            Node<T> tmp = head;
            head = head.getNext();
            --count;
            return tmp.getData();
        }

        Node<T> currentNode = setCurrentNode(index - 1);
        Node<T> tmp = currentNode.getNext();
        currentNode.setNext(tmp.getNext());
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

        Node<T> currentNode = setCurrentNode(index - 1);
        Node<T> newNode = new Node<>(value);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        ++count;
    }

    //удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean deleteValue(T value) {
        if (head == null) {
            throw new IllegalArgumentException("The list is void, nothing to delete");
        }

        if (head.getData().equals(value)) {
            head = head.getNext();
            --count;
            return true;
        }

        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getData().equals(value)) {
                currentNode.setNext(currentNode.getNext().getNext());
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
            throw new IllegalArgumentException("The list is void, nothing to delete");
        }
        T tmp = head.getData();
        head = head.getNext();
        --count;
        return tmp;
    }

    //разворот списка за линейное время
    public void reverse() {
        if (head == null) {
            return;
        }

        Node<T> first = head;
        Node<T> second = head.getNext();
        if (second == null) {
            return;
        }
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
    public LinkedList<T> copy() {
        LinkedList<T> newList = new LinkedList<>();
        if (this.head == null) {
            return newList;
        }
        newList.insertIndexValue(0, this.head.getData());
        Node<T> newListNode = new Node<>();
        newList.head.setNext(newListNode);
        Node<T> tempNode = this.head.getNext();
        for (int i = 1; i < this.getCount(); i++) {
            newListNode.setData(tempNode.getData());

            tempNode = tempNode.getNext();
            if (tempNode != null) {
                newListNode.setNext(new Node<>());
            }
            newListNode = newListNode.getNext();
        }
        newList.count = this.getCount();
        return newList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = head;

        if (head == null) {
            return null;
        }

        sb.append("(");
        sb.append(currentNode.getData());
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            sb.append(", ");
            sb.append(currentNode.getData());
        }
        sb.append(")");
        return sb.toString();
    }
}




