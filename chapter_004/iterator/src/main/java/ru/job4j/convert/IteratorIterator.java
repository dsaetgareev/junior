package ru.job4j.convert;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * implements method Iterator<Integer> convert(Iterator<Iterator<Integer>> it).
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 11.04.2017
 * @version 1.0
 */
public class IteratorIterator {
    /**
     * converting Iterator<Iterator<Integer>> to Iterator<Integer>.
     * @param it Iterator<Iterator<Integer>>
     * @return Iterator<Integer>
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        ArrayList<Integer> list = new ArrayList<>();
        while (it.hasNext()) {
            Iterator<Integer> iter = it.next();
            while (iter.hasNext()) {
                list.add(iter.next());
            }
        }
        return list.iterator();
    }
}
