package ru.job4j.even;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * class IteratorEven implements Iterator, return even values.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 10.04.2017
 * @version 1.0
 */
public class IteratorEven implements Iterator {
    /**
     * ArrayList.
     */
    private ArrayList<Integer> list = new ArrayList<>();
    /**
     * index of iterator.
     */
    private int index = 0;
    /**
     * count for next().
     */
    private int countNext = 0;

    /**
     * constructor.
     * @param list - new list
     */
    public IteratorEven(ArrayList<Integer> list) {
        this.list = list;
    }

    /**
     * checks for the next element.
     * @return boolean
     */
    public boolean hasNext() {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                count++;
            }
        }
        return count > this.countNext;
    }

    /**
     * return next even element.
     * @return even element
     */
    public Integer next() {
        int result = 0;
        for (int i = index; i < list.size(); i++) {
           if (list.get(i) % 2 == 0) {
               result = list.get(i);
               index = i + 1;
               countNext++;
               break;
           }
        }
        return result;
    }
}
