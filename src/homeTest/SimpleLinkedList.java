package homeTest;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SimpleLinkedList <E> implements SimpleList<E> {
    private Node<E> root;
    private Node<E> last = null; // tail
    private int size = 0;
    private int modCount;

    public SimpleLinkedList () {
        root = null;
    }

    private static class Node<T> {
        private Node <T> prev;
        private T item;
        private Node <T> next;

        private Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || size < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    private Node<E> node(int index) {
        if (index < size / 2) {
            Node<E> tmp = root;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }
    private E unlink(Node<E> x) { //todo:
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            root = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    @Override
    public boolean add(E newElement) {
        final Node<E> tmp = last;
        final Node<E> newNode = new Node<>(tmp, newElement, null);
        last = newNode;
        if (tmp == null) {
            root = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
        return true;
    }
    @Override
    public E get(int index) {
        checkIndex(index);
        return node(index).item;
    }

    @Override
    public LinkedListIterator<E> iterator() {
        return new LinkedListIterator<>();
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
        checkIndex(index);
        return unlink(node(index));
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append('[');

        Node node = root;
        while (node != null) {
            result.append(node.item);
            if (node.next != null) {
                result.append(", ");
            }
            node = node.next;
        }

        result.append(']');
        return result.toString();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof SimpleLinkedList)) {
            return false;
        }
        SimpleLinkedList list = (SimpleLinkedList) o;

        if (list.size != size) {return false;}

        boolean equal = true;
        for (Node x = this.last, y = list.last; x != null; x = x.prev, y = y.prev) {
            System.out.print(y.item + " = ");
            System.out.println(x.item);
            if (y.item.equals(x.item)) {equal = true;}
            else {return false;}
        }
        return equal;
    }

    public int hashCode() {
        int hashCode = 1;
        for (Node x = this.last; x != null; x = x.prev) {
            hashCode = 11 * hashCode;
        }
        return hashCode;
    }

    private class LinkedListIterator<T> implements Iterator<T> {

        private Node curr;
        private Node prev;
        private Node next;

        private boolean removed;

        private int expectedModCount = modCount;

        public LinkedListIterator() {
            this.curr = null;
            this.prev = null;
            this.removed = false;
        }

        @Override
        public boolean hasNext() {
            return (curr == null && prev == null && root != null)
                    || (curr != null && curr.next != null);
        }

        @Override
        public T next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            removed = false;

            if (curr == null && prev == null) {
                curr = root;
                prev = null;
                return (T)curr.item;
            } else {
                prev = curr;
                curr = curr.next;
                return (T)curr.item;
            }
        }

        @Override
        public void remove() {
            checkForComodification();
            if (removed || curr == null) {
                throw new IllegalStateException();
            }

            if (curr == root) {
                root = curr.next;
            } else if (prev != null) {
                Node next = curr.next;
                curr = prev;
                curr.next = next;
            }
            prev = null;
            removed = true;

            modCount++;
            expectedModCount = modCount;
        }

        private void checkForComodification() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }

    }

}
