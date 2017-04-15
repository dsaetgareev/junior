package ru.job4j.iterator;

import java.util.Iterator;

/**
 * class IteratorArray implements Iterator.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 09.04.2017
 */
public class IteratorArray implements Iterator {
    /**
     * array.
     */
    private int[][] values;
    /**
     * index for column.
     */
    private int indexColumn = 0;
    /**
     * index for line.
     */
    private int indexLine = 0;

    /**
     * constructor.
     *
     * @param values - new values
     */
    public IteratorArray(int[][] values) {
        this.values = values;
    }

    /**
     * checks for the next element.
     *
     * @return boolean
     */
    public boolean hasNext() {
        int count = 0;
        int countHasNext = 0;
        for (int[] array : this.values) {
            countHasNext += array.length;
        }
        for (int i = 0; i < this.indexLine; i++) {
            count += this.values[i].length;
        }
        count += this.indexColumn;
        return countHasNext > count;
    }

    /**
     * return next element.
     *
     * @return next element
     */
    public Integer next() {
        Integer result = this.values[this.indexLine][this.indexColumn];
        if (this.indexColumn == this.values[this.indexLine].length - 1) {
            this.indexColumn = 0;
            this.indexLine = this.indexLine + 1;
        } else {
            this.indexColumn++;
        }
        return result;
    }
}
