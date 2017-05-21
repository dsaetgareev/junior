package ru.job4j.simpleararylist;

import ru.job4j.simplecontainer.SimpleContainer;

import java.util.Iterator;

/**
 * container SimpleArrayList<E> implements SimpleContainer<E>.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 16.04.2017
 * @version 1.0
 * @param <E> - some type
 */
public class SimpleArrayList<E> implements SimpleContainer<E> {

    /**
     * array for objects.
     */
    private Object[] objects;
    /**
     * index of position.
     */
    private int size = 0;

    /**
     * constructor.
     *
     * @param size - size of array.
     */
    public SimpleArrayList(int size) {
        this.objects = (E[]) new Object[size];
    }

    /**
     * constructor.
     *
     * @param objects - new objects
     */
    public SimpleArrayList(E[] objects) {
        this.objects = objects;
        this.size = objects.length;
    }

    /**
     * adds new element.
     *
     * @param e -new element
     */
    public synchronized void add(E e) {
        this.objects[this.size++] = e;
        if (this.size == this.objects.length) {
            int length = (int) (this.size * 1.5);
            Object[] temp = new Object[length];
            System.arraycopy(this.objects, 0, temp, 0, this.size);
            this.objects = temp;
        }
    }

    /**
     * return size.
     *
     * @return - size
     */
    public synchronized int size() {
        return this.size;
    }

    /**
     * return this element.
     *
     * @param index - index of element
     * @return e - element
     */
    public synchronized E get(int index) {
        return (E) this.objects[index];
    }

    /**
     * remove this element.
     *
     * @param index - index of element
     */
    public synchronized void remove(int index) {
        int amountElement = this.objects.length - index - 1;
        System.arraycopy(this.objects, index + 1, this.objects, index, amountElement);
        this.size--;
        this.objects[this.size] = null;
    }
    /**
     * iterator.
     * @return - Iterator<E>
     */
    public synchronized Iterator<E> iterator() {
        return new SimpleArrayListIterator();
    }
    /**
     * create iterator.
     */
    private class SimpleArrayListIterator implements Iterator<E> {
        /**
         * cursor.
         */
        private int cursor = 0;

        /**
         * checks for the next element.
         *
         * @return - boolean
         */
        public boolean hasNext() {
            return size != cursor;
        }

        /**
         * return next element.
         *
         * @return - return next element
         */
        public E next() {
            return (E) objects[cursor++];
        }
    }
}
