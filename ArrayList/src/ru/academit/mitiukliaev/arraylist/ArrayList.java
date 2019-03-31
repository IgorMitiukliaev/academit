package ru.academit.mitiukliaev.arraylist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int size;

    //TODO class Iterator
    private class MyArrayListIterator implements Iterator<T> {
        @Override
        public boolean hasNext() {
            //   Returns true if the iteration has more elements.
        }

        @Override
        public T next() {
//Returns the next element in the iteration.
        }
    }

    //TODO constructors
    public MyArrayList() {
        items = (T[]) new Object[10];
    }


    //TODO ------METHODS-------

    @Override
    public ListIterator<T> listIterator() {
        // Returns a list iterator over the elements in this list(in proper sequence).
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // Returns a list iterator over the elements in this list(in proper sequence), starting at the specified position in the list.
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public boolean add(T e) {
        return false;
    }

    @Override
    public boolean add(int index, T e) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
//  Compares the specified object with this list for equality.
    }

    @Override
    public T get(int index) {
//   Returns the element at the specified position in this list.
    }

    @Override
    public int indexOf(Object o) {
        // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
    }


    @Override
    public int lastIndexOf(Object o) {
        // Returns the index of the last occurrence of the specified element in this list, or - 1 if this list does not contain the element.
    }

    @Override
    public T set(int index, T element) {

    }

    @Override
    public int hashCode() {
//  Returns the hash code value for this list.
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {

    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

    }

    @Override
    public void clear() {
    }

    @Override
    public T remove(int index) {
    }

    @Override
    public boolean remove(Object o) {
    }

    @Override
    public boolean removeAll(Collection<?> c) {

    }

    @Override
    public boolean retainAll(Collection<?> c) {

    }

    @Override
    public boolean contains(Object o) {
    }

    @Override
    public boolean containsAll(Collection<?> c) {
    }

    @Override
    public Object[] toArray() {
        T[] array = new T[];
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        //    Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
    }

    @Override
    public int size() {
        int size = 0;
        return size;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    //TODO trimToSize
    public void trimToSize() {
    }

    //TODO ensureCapacity
    public void ensureCapacity(int size) {
    }
}
