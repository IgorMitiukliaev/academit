package ru.academit.mitiukliaev.hashtable;

import java.util.*;

public class MyHashTable<E> implements Collection<E> {
    private ArrayList<E>[] items;
    private int size;
    private int modCount;

    private class MyIterator<E> implements Iterator<E> {
        private int currentNodeNumber = 0;
        private int currentArrayIndex = 0;
        private int currentIndex = -1;
        private int initModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex < size - 1;
        }

        @Override
        @SuppressWarnings("unchecked")
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
            return (E) items[currentArrayIndex].get(currentNodeNumber++);
        }

        public void remove() {
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>();
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

    private int getKey(E e) {
        return Math.abs(e.hashCode() % items.length);
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
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        E tmp = (E) o;
        if (items[getKey(tmp)] == null) {
            return false;
        }
        for (E e : items[getKey(tmp)]) {
            if (tmp.equals(e)) {
                return true;
            }
        }
        return false;
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
        return Arrays.copyOf(items, size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a == null) {
            throw new NullPointerException("The specified array is null");
        }
        if (a.length <= size) {
            return (T[]) Arrays.copyOf(items, size, a.getClass());
        }
        System.arraycopy(items, 0, a, 0, size);
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
            int key = getKey(e);
            if (items[key] == null) {
                items[key] = new ArrayList<>(1);
            }
            ++size;
            items[key].add(e);
        }
        ++modCount;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        E tmp = (E) o;
        int key = getKey(tmp);
        //if (items[key] != null){
        // System.out.println("Object is not an instance of " + items[0].getClass());}
        --size;
        ++modCount;
        return (items[key] != null && items[key].remove(tmp));
    }

    //TODO
    private boolean batchRemove(Collection<?> c, boolean argument) {
        return false;
    }

    //TODO
    @Override
    public boolean removeAll(Collection<?> c) {
        return batchRemove(c, false);
    }

    //TODO
    @Override
    public boolean retainAll(Collection<?> c) {
        return batchRemove(c, true);
    }

    @Override
    public void clear() {
        Arrays.fill(items, null);
        size = 0;
    }

    public String toString() {
        if (size == 0) {
            throw new IllegalArgumentException("The list is empty");
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
