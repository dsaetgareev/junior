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
     * number of iterations.
     */
    private int count = 0;

    /**
     * constructor.
     *
     * @param values - new values
     */
    public IteratorArray(int[][] values) {
        this.values = values;
    }

    /**
     * calculate this.values length.
     *
     * @return count
     */
    public int length() {
        int count = 0;
        for (int[] array : this.values) {
            count += array.length;
        }
        return count;
    }

    /**
     * checks for the next element.
     *
     * @return boolean
     */
    public boolean hasNext() {
        return this.length() > this.count;
    }

    /**
     * return next element.
     *
     * @return next element
     */
    public Integer next() {
        Integer result = 0;
        for (int i = this.indexLine; i < this.values.length; i++) {
            result = this.values[i][this.indexColumn];
            this.indexColumn++;
            if (this.indexColumn == this.values[i].length) {
                this.indexColumn = 0;
                this.indexLine = i + 1;
            }
            this.count++;
            break;
        }
        return result;
    }
}
