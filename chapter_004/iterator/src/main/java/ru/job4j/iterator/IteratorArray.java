package ru.job4j.iterator;

import java.util.Iterator;

/**
 * class IteratorArray implements Iterator.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 09.04.2017
 * @version 1.0
 */
public class IteratorArray implements Iterator {
    /**
     * array.
     */
    private int[][] values;
    /**
     * index for iterator.
     */
    private int index = 0;

    /**
     * constructor.
     * @param values - new values
     */
    public IteratorArray(int[][] values) {
        this.values = values;
    }

    /**
     * calculate this.values length.
     * @return count
     */
    public int length() {
        int count = 0;
        for (int[] array : this.values) {
            for (int element : array) {
                count++;
            }
        }
        return count;
    }

    /**
     * checks for the next element.
     * @return boolean
     */
    public boolean hasNext() {
        return this.length() > this.index;
    }

    /**
     * return next element.
     * @return next element
     */
    public Object next() {
        Object[] result = new Object[length()];
        int i = 0;
        for (int[] array : this.values) {
            for (int element : array) {
                result[i++] = element;
            }
        }
        return  result[index++];
    }
}
