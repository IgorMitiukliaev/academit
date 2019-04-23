package ru.academit.mitiukliaev.arraylist;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private E[] items;
    private int size;
    private int modCount;

    private class MyArrayListIterator implements Iterator<E> {
        private int currentIndex = -1;
        private int initModCount = modCount;

        public boolean hasNext() {
            //   Returns true if the iteration has more elements.
            return currentIndex < size - 1;
        }

        public E next() {
            //Returns the next element in the iteration.
            if (!this.hasNext()) {
                throw new NoSuchElementException("End of collection reached");
            }
            if (modCount != initModCount) {
                throw new ConcurrentModificationException("Collection changed during iterations");
            }
            ++currentIndex;
            return items[currentIndex];
        }
    }

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        items = (E[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        this.items = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(Collection<? extends E> c) {
        size = c.size();
        items = (E[]) new Object[size + 10];
        System.arraycopy((E[]) c.toArray(), 0, items, 0, size);

    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        // Returns a list iterator over the elements in this list(in proper sequence).
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // Returns a list iterator over the elements in this list(in proper sequence), starting at the specified position in the list.
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        //    Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
        return null;
    }

    @Override
    public boolean add(E element) {
        // Appends the specified element to the end of this list (optional operation).
        if (size == items.length) {
            this.ensureCapacity(2 * size + 1);
        }
        this.items[size] = element;
        ++size;
        ++modCount;
        return true;
    }

    @Override
    public void add(int index, E element) {
        // Inserts the specified element at the specified position in this list (optional operation).
        // Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("index " + index + " is out of range, size = " + size);
        }
        if (size == items.length) {
            this.ensureCapacity(2 * size + 1);
        }
        if (index < size) {
            System.arraycopy(this.items, index, this.items, index + 1, size - index);
        }
        this.items[index] = element;

        ++size;
        ++modCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof List)) {
            return false;
        }
        Iterator<E> e1 = iterator();
        Iterator e2 = ((List) o).iterator();
        while (e1.hasNext() && e2.hasNext()) {
            E o1 = e1.next();
            Object o2 = e2.next();
            if (!(Objects.equals(o1, o2))) {
                return false;
            }
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("index " + index + " is out of range, size = " + size);
        }
//   Returns the element at the specified position in this list.
        return this.items[index];
    }

    @Override
    public int indexOf(Object o) {
        // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, items[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        // Returns the index of the last occurrence of the specified element in this list, or - 1 if this list does not contain the element.
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(o, items[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E set(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds, Size: " + size);
        }
        E tmp = this.items[index];
        this.items[index] = element;
        return tmp;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (int i = 0; i < size; i++) {
            hashCode = 31 * hashCode + (items[i] == null ? 0 : items[i].hashCode());
        }
        return hashCode;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // Inserts all of the elements in the specified collection into this list at the specified position.
        // Shifts the element currently at that position (if any) and any subsequent elements to the right.
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds, Size: " + size);
        }
        int collectionLength = c.size();
        if (collectionLength == 0) {
            return false;
        }
        ensureCapacity(size + collectionLength);

        int numMoved = size - index;
        if (numMoved > 0) {
            System.arraycopy(items, index, items, index + collectionLength, numMoved);
        }
        for (E e : c) {
            this.items[size] = e;
            ++size;
        }
        ++modCount;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int collectionLength = c.size();
        if (collectionLength == 0) {
            return false;
        }
        ensureCapacity(size + collectionLength);
        for (E e : c) {
            this.items[size] = e;
            ++size;
        }
        ++modCount;
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(items, null);
        ++modCount;
        size = 0;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("index " + index + " is out of range, size() = " + size);
        }
        E tmp = this.items[index];
        this.items[index] = null;
        if (index < size) {
            System.arraycopy(this.items, index + 1, this.items, index, size - index - 1);
        }
        --size;
        ++modCount;
        return tmp;
    }

    @Override
    public boolean remove(Object o) {
        int index = this.indexOf(o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    private boolean batchRemove(Collection<?> c, boolean argument) {
        int n = 0;
        int i;
        for (i = 0; i < size; i++) {
            if (c.contains(items[i]) == argument) {
                items[n] = items[i];
                n++;
            }
        }
        if (n == i) {
            return false;
        }
        Arrays.fill(items, n, size, null);
        size = n;
        ++modCount;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // Removes from this list all of its elements that are contained in the specified collection (optional operation).
        // Returns true if this list changed as a result of the call
        return batchRemove(c, false);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // Retains only the elements in this list that are contained in the specified collection (optional operation).
        // In other words, removes from this list all of its elements that are not contained in the specified collection.
        // Returns true if this list changed as a result of the call
        return batchRemove(c, true);
    }

    @Override
    public boolean contains(Object o) {
        // returns true if and only if this list contains at least one element e such that (o==null ? e==null : o.equals(e)).
        return indexOf(o) >= 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // Returns true if this list contains all of the elements of the specified collection.
        for (Object e : c) {
            if (!this.contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public E[] toArray() {
        // Returns an array containing all of the elements in this list in proper sequence (from first to last element).
        return Arrays.copyOf(items, size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a == null) {
            throw new NullPointerException("The specified array is null");
        }
        // Returns an array containing all of the elements in this list in proper sequence
        // (from first to last element); the runtime type of the returned array is that of the specified array.
        // If the list fits in the specified array, it is returned therein.
        // Otherwise, a new array is allocated with the runtime type of the specified array and the size of this list.
        // If the list fits in the specified array with room to spare (i.e., the array has more elements than the list),
        // the element in the array immediately following the end of the collection is set to null.
        if (a.length < size) {
            return (T[]) Arrays.copyOf(items, size, a.getClass());
        }
        System.arraycopy((T[]) items, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    public void trimToSize() {
        if (size < this.items.length) {
            this.items = Arrays.copyOf(this.items, size);
        }
    }

    public void ensureCapacity(int capacity) {
        if (capacity > items.length) {
            this.items = Arrays.copyOf(this.items, capacity);
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "(empty)";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        sb.append("Size = ");
        sb.append(size);
        sb.append(" | ");

        for (int i = 0; i < size - 1; i++) {
            sb.append(items[i]);
            sb.append(", ");
        }
        sb.append(items[size - 1]);
        sb.append(" )");
        return sb.toString();
    }
}



