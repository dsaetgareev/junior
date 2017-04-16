package ru.job4j.generic;

import java.util.Iterator;

/**
 * class SimpleArray<E> implements a container.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 13.04.2017
 * @version 1.0
 * @param <E> - some type
 */
public class SimpleArray<E> {
    /**
     * array for objects.
     */
    private Object[] objects;
    /**
     * index of position.
     */
    private int index = 0;

    /**
     * constructor.
     * @param size - size of array.
     */
    public SimpleArray(int size) {
        this.objects = (E[]) new Object[size];
    }

    /**
     * constructor.
     * @param objects - new objects
     */
    public SimpleArray(E[] objects) {
        this.objects = objects;
        this.index = objects.length;
    }

    /**
     * add new element.
     * @param value - new element
     */
    public void add(E value) {
        this.objects[this.index++] = value;
        if (this.index == this.objects.length) {
            int size = (int) (this.index * 1.5);
            Object[] temp = new Object[size];
            System.arraycopy(this.objects, 0, temp, 0, index);
            this.objects = temp;
        }
    }

    /**
     * get position.
     * @param position - index position
     * @return - object
     */
    public E get(int position) {
        return (E) this.objects[position];
    }

    /**
     * edit array.
     * @param position - position of this.objects
     * @param value - new value
     */
    public void update(int position, E value) {
        this.objects[position] = value;
    }

    /**
     * remove by position.
     * @param position - position of this.objects
     */
    public void delete(int position) {
        int amountElement = this.objects.length - position - 1;
        System.arraycopy(this.objects, position + 1, this.objects, position, amountElement);
        this.index--;
        this.objects[index] = null;
    }

    /**
     * remove by value.
     * @param value - value of this.objects
     */
    public void delete(E value) {
        for (int i = 0; i < this.objects.length; i++) {
            if (value.equals(this.objects[i])) {
                int amountElement = this.objects.length - i - 1;
                System.arraycopy(this.objects, i + 1, this.objects, i, amountElement);
                this.index--;
                this.objects[index] = null;
            }
        }

    }

    /**
     * return size.
     * @return size
     */
    public int size() {
        return index;
    }

    /**
     * iterator.
     * @return - Iterator<E>
     */
    public Iterator<E> iteratorSimple() {
        return new SimpleIterator();
    }

    /**
     * create iterator.
     */
    private class SimpleIterator implements Iterator<E> {
        /**
         * cursor.
         */
        private int cursor = 0;

        /**
         * checks for the next element.
         * @return - boolean
         */
        public boolean hasNext() {
            return index != cursor;
        }

        /**
         * return next element.
         * @return - return next element
         */
        public E next() {
            return (E) objects[cursor++];
        }
    }
}
