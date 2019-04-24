package ru.academit.mitiukliaev.hashtable;

import java.util.*;

public class MyHashTable<E> implements Collection<E> {
    private ArrayList<E>[] items;
    private int size;
    private int modCount;

    private class MyIterator implements Iterator<E> {
        private int currentNodeNumber = 0;
        private int currentArrayIndex = 0;
        private int currentIndex = -1;
        private int initModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex < size - 1;
        }

        @Override
        public E next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException("End of collection reached");
            }
            if (modCount != initModCount) {
                throw new ConcurrentModificationException("Collection changed during iterations");
            }
            while (items[currentArrayIndex] == null || currentNodeNumber == items[currentArrayIndex].size()) {
                ++currentArrayIndex;
                currentNodeNumber = 0;
            }
            ++currentIndex;
            int prevNodeNumber = currentNodeNumber;
            ++currentNodeNumber;
            return items[currentArrayIndex].get(prevNodeNumber);
        }

        @Override
        public void remove() {
            ++modCount;
            initModCount = modCount;
            --size;
            --currentIndex;
            currentNodeNumber--;
            items[currentArrayIndex].remove(currentNodeNumber);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        items = new ArrayList[16];
    }

    @SuppressWarnings("unchecked")
    public MyHashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        items = new ArrayList[capacity];
    }

    private int getKey(Object e) {
        return (e == null ? 0 : Math.abs(e.hashCode() % items.length));
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public boolean contains(Object o) {
        int key = getKey(o);
        return (items[key] != null && items[key].contains(o));
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!this.contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] tmp = new Object[size];
        int i = 0;
        for (E e : this) {
            tmp[i] = e;
            ++i;
        }
        return tmp;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a == null) {
            throw new NullPointerException("The specified array is null");
        }
        if (a.length < size) {
            return (T[]) Arrays.copyOf(this.toArray(), size, a.getClass());
        }
        System.arraycopy((T[]) this.toArray(), 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        int key = getKey(e);
        if (items[key] == null) {
            items[key] = new ArrayList<>(1);
        }
        ++size;
        ++modCount;
        return items[key].add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int collectionLength = c.size();
        if (collectionLength == 0) {
            return false;
        }
        for (E e : c) {
            this.add(e);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int key = getKey(o);
        if (items[key] != null && items[key].remove(o)) {
            --size;
            ++modCount;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean hasChanged = false;
        for (Object e : c) {
            while (this.remove(e)) {
                hasChanged = true;
            }
        }
        return hasChanged;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean hasChanged = false;
        Iterator<E> e = iterator();
        while (e.hasNext()) {
            E o = e.next();
            if (!c.contains(o)) {
                e.remove();
                hasChanged = true;
            }
        }
        return hasChanged;
    }

    @Override
    public void clear() {
        Arrays.fill(items, null);
        size = 0;
        ++modCount;
    }

    public String toString() {
        if (size == 0) {
            return ("( Size = 0 )");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        sb.append("Size = ");
        sb.append(size);
        sb.append(" | ");

        for (int i = 0; i < items.length - 1; i++) {
            sb.append(items[i]);
            sb.append(", ");
        }
        sb.append(items[items.length - 1]);
        sb.append(" )");
        return sb.toString();
    }
}
