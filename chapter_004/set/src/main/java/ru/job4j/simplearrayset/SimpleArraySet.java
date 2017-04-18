package ru.job4j.simplearrayset;

import java.util.Iterator;

/**
 * container SimpleArraySet<E> .
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 18.04.2017
 * @param <E> some object
 */
public class SimpleArraySet<E> {
    /**
     * database.
     */
    private Object[] arraySet;
    /**
     * size for database.
     */
    private int size = 0;

    /**
     * constructor.
     */
    public SimpleArraySet() {
        this.arraySet = new Object[10];
    }

    /**
     * constructor.
     * @param arraySet - new database
     */
    public SimpleArraySet(E[] arraySet) {
        this.arraySet = arraySet;
        this.size = arraySet.length;
    }

    /**
     * adds new element.
     * @param e - new element
     */
    public void add(E e) {
        if (this.size == 0) {
            this.arraySet[0] = e;
            this.size++;
        } else {
            if (this.hasDuplicate(e)) {
                this.arraySet[size] = e;
                this.size++;
            }
            if (this.size == this.arraySet.length) {
                this.increaseArray();
            }
        }
    }

    /**
     * checks for availability duplicates.
     * @param e checked item
     * @return boolean
     */
    public boolean hasDuplicate(E e) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (e.equals(this.arraySet[i])) {
                count++;
            }
        }
        return count == 0 ? true : false;
    }

    /**
     * increases array.
     */
    public void increaseArray() {
        int length = (int) (this.size * 1.5);
        Object[] temp = new Object[length];
        System.arraycopy(this.arraySet, 0, temp, 0, this.size);
        this.arraySet = temp;
    }

    /**
     * return size of database.
     * @return size
     */
    public int size() {
        return this.size;
    }
    /**
     * iterator.
     * @return - Iterator<E>
     */
    Iterator<E> iterator() {
        return new SimpleArraySetIterator();
    }
    /**
     * create iterator.
     */
    private class SimpleArraySetIterator implements Iterator<E> {
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
            return size != this.cursor;
        }
        /**
         * return next element.
         *
         * @return - return next element
         */
        public E next() {
            return (E) arraySet[cursor++];
        }
    }
}
