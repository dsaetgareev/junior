package ru.job4j.simple;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * class IteratorSimple implements Iterator, return simple values.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 10.04.2017
 */
public class IteratorSimple implements Iterator {
    /**
     * ArrayList.
     */
    private ArrayList<Integer> list;
    /**
     * index of iterator.
     */
    private int index = 0;

    /**
     * constructor.
     *
     * @param list - new list
     */
    public IteratorSimple(ArrayList<Integer> list) {
        this.list = list;
    }

    /**
     * checks for the next element.
     *
     * @return boolean
     */
    public boolean hasNext() {
        return this.list.size() > index;
    }

    /**
     * return next simple element.
     *
     * @return even element
     */
    public Integer next() {
        int result = 0;
        for (int i = this.index; i < this.list.size(); i++) {
            int count = 0;
            for (int j = 1; j < this.list.get(i); j++) {
                if (j != 1 && this.list.get(i) % j == 0) {
                    count++;
                }
            }
            if (this.list.get(i) != 1 && count == 0) {
                result = this.list.get(i);
                index = i + 1;
                break;
            }
        }
        return result;
    }
}
