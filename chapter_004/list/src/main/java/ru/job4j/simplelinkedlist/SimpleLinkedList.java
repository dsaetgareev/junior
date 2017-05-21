package ru.job4j.simplelinkedlist;

import ru.job4j.simplecontainer.SimpleContainer;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * container SimpleLinkedList<E> implements SimpleContainer<E>, Iterable<E>.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 16.04.2017
 * @version 1.0
 * @param <E> - some type
 */
public class SimpleLinkedList<E> implements SimpleContainer<E>, Iterable<E> {
    /**
     * size of container.
     */
    private int size = 0;
    /**
     * first element.
     */
    private SimpleNode<E> first;
    /**
     * last element.
     */
    private SimpleNode<E> last;

    /**
     * constructor.
     */
    public SimpleLinkedList() {

    }

    /**
     * adds new element.
     * @param e -new element
     */
    public synchronized void add(E e) {
        final SimpleNode<E> l = last;
        final SimpleNode<E> newSNode = new SimpleNode(l, e, null);
        last = newSNode;
        if (l == null) {
            first = newSNode;
        } else {
            l.next = newSNode;
        }
        size++;
    }

    /**
     * return size.
     * @return size
     */
    public synchronized int size() {
        return size;
    }

    /**
     * get element by index.
     * @param index - index of element
     * @return element
     */
    public synchronized E get(int index) {
        E result = null;
        if (index >= 0 && index < size) {
            if (index < (size / 2)) {
                SimpleNode<E> x = first;
                for (int i = 0; i < index; i++) {
                    x = x.next;
                }
                result = x.item;
            } else {
                SimpleNode<E> x = last;
                for (int i = size - 1; i > index; i--) {
                    x = x.prev;
                }
                result = x.item;
            }
        }
        return result;
    }

    /**
     * remove element by index.
     * @param index - index of element that remove
     */
    public synchronized void remove(int index) {
        SimpleNode<E> temp = null;
        if (index >= 0 && index < size) {
            if (index < (size >> 1)) {
                SimpleNode<E> x = first;
                for (int i = 0; i < index; i++) {
                    x = x.next;
                }
                temp = x;
            } else {
                SimpleNode<E> x = last;
                for (int i = size - 1; i > index; i--) {
                    x = x.prev;
                }
                temp = x;
            }
        }
        if (temp != null) {
            SimpleNode<E> tempNext = temp.next;
            SimpleNode<E> tempPrev = temp.prev;
            if (tempPrev == null) {
                this.first = tempNext;
            } else {
                tempPrev.next = tempNext;
                temp.prev = null;
            }
            if (tempNext == null) {
                this.last = tempPrev;
            } else {
                tempNext.prev = tempPrev;
                temp.next = null;
            }
            temp.item = null;
            size--;
        }
    }

    /**
     * class SimpleNode<E>.
     * @param <E> - element
     */
    private static class SimpleNode<E> {
        /**
         * value of element.
         */
        private E item;
        /**
         * pointer to next element.
         */
        private SimpleNode<E> next;
        /**
         * pointer to previous element.
         */
        private SimpleNode<E> prev;

        /**
         * constructor.
         * @param prev - new prev
         * @param item - new item
         * @param next new next
         */
        SimpleNode(SimpleNode<E> prev, E item, SimpleNode<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * iterator().
     * @return Iterator<E>
     */
    public synchronized Iterator<E> iterator() {
        return new SimpleLinkedIterator();
    }

    /**
     * class SimpleLinkedIterator implements Iterator<E>.
     */
    private class SimpleLinkedIterator implements Iterator<E> {
        /**
         * counter cursor.
         */
        private int cursor = 0;
        /**
         * counter for remove.
         */
        private int lastRet = -1;

        /**
         * checking next element.
         * @return boolean
         */
        public boolean hasNext() {
            return size > this.cursor;
        }

        /**
         * returns next element.
         * @return E next element
         */
        public E next() {
            try {
                int i = cursor;
                E next = get(i);
                lastRet = i;
                cursor++;
                return next;
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                throw new NoSuchElementException();
            }
        }

        /**
         * removes element.
         */
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }

            try {
                SimpleLinkedList.this.remove(lastRet);
                if (lastRet < cursor) {
                    cursor--;
                    lastRet = -1;
                }
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
