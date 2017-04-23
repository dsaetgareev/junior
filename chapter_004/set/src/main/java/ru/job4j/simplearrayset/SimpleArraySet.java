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
     * constructor.
     * @param arraySet - new arraySet
     * @param size - new size
     */
    public SimpleArraySet(E[] arraySet, int size) {
        this.arraySet = arraySet;
        this.size = size;
    }

    /**
     * gets this.arraySet.
     * @return this.arraySet
     */
    public E[] getArraySet() {
        return (E[]) this.arraySet;
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
            this.increaseArray();
        }
    }

    /**
     * checks for availability duplicates.
     * @param e checked item
     * @return boolean
     */
    public boolean hasDuplicate(E e) {
        for (Object elem : this.arraySet) {
            if (e.equals(elem)) {
                return false;
            }
        }
        return true;
    }

    /**
     * increases array.
     */
    public void increaseArray() {
        if (this.size == this.arraySet.length) {
            int length = (int) (this.size * 1.5);
            Object[] temp = new Object[length];
            System.arraycopy(this.arraySet, 0, temp, 0, this.size);
            this.arraySet = temp;
        }
    }

    /**
     * return size of database.
     * @return size
     */
    public int size() {
        return this.size;
    }

    /**
     * iterates this.size.
     */
    public void sizeIter() {
        this.size++;
    }

    /**
     * get element.
     * @param position - index of position
     * @return element
     */
    @SuppressWarnings("unchecked")
    public E get(int position) {
        return (E) this.arraySet[position];
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
