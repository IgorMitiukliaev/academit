package ru.academit.mitiukliaev.list;

import java.util.Objects;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node<T> next) {
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
        return ((data == null) ? "" : data.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (Objects.equals(this, o)) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Node tmpNode = (Node) o;
        return tmpNode.getData().equals(this.getData()) && tmpNode.getNext().equals(this.getNext());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((next == null) ? 0 : next.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        return result;
    }
}


