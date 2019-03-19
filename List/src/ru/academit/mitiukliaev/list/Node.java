package ru.academit.mitiukliaev.list;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node() {
        this.data = null;
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return this.data;
    }

    public T setData(T data) {
        T tmp = this.data;
        this.data = data;
        return tmp;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Node tmpNode = (Node) o;
        return tmpNode.getData() == this.getData() && tmpNode.getNext() == this.getNext();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((next == null) ? 0 : next.hashCode());
        result = prime * result + data.hashCode();
        return result;
    }
}


