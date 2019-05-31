package homeTest;

import java.util.*;

public class SimpleArrayList <E> implements SimpleList<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 0;
    private E[] data;
    private int size = 0;
    private int count;

    public SimpleArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public SimpleArrayList(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(E newElement) {
        ensureCapacity(size + 1);
        data[size] = newElement;
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return data[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleArrayListIterator<>();
    }

    public String toString() {
        return Arrays.toString(data);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof SimpleArrayList)) {
            return false;
        }
        SimpleArrayList list = (SimpleArrayList) o;

        if (list.size != size) {return false;}

        final int expectedModCount = count;
        Boolean equal = true;
        for (int i = 0; i < list.size; i++) {
            if (!list.get(i).equals(get(i))) {equal = false;}

        }
        return equal;
    }

    public int hashCode() {
        int hashCode = 1;
        for (int i = 0; i < size; i++) {
            hashCode = 11 * hashCode; //+ (this == null ? 0 : this.hashCode());
        }
        return hashCode;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = data[index];
        int numMoved = size - index - 1;
        E[] newData = (E[]) new Object[size - 1];
        if (index > 0) {
            System.arraycopy(data, 0, newData, 0, index);
        }
        System.arraycopy(data, index + 1, newData, index, numMoved);
        this.size--;
        this.data = newData;
        //data[--size] = null;
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index < 0 || size < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = minCapacity;
            E[] newData = (E[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            this.data = newData;
        }
    }

    private class SimpleArrayListIterator<T> implements Iterator<T> {

        private int cursor;  // index of next element to return
        private int lastRet; // index of last element returned; -1 if no such
        private int expectedModCount = count;

        public SimpleArrayListIterator() {
            this.cursor = 0;
            this.lastRet = -1;
        }

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public T next() {
            checkForComodification();
            int i = cursor;
            if (i >= size()) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            return (T) SimpleArrayList.this.get(lastRet = i);
        }

        @Override
        public void remove() {
            checkForComodification();
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            SimpleArrayList.this.remove(lastRet);
            expectedModCount = count;
            cursor = lastRet;
            lastRet = -1;
        }

        public T current () {
            return (T) SimpleArrayList.this.get(cursor);
        }

        private void checkForComodification() {
            if (expectedModCount != count) {
                throw new ConcurrentModificationException();
            }
        }

    }

}

interface SimpleList<E> {
    public boolean add(E newElement);
    public E get(int index);
    public Iterator<E> iterator();
    public int size();
    public boolean isEmpty();
    public E remove(int index);
}
