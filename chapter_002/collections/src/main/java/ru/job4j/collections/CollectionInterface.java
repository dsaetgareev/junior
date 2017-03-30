package ru.job4j.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * class CollectionInterface - contains methods that testing time operation Collection.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 29.03.2017
 */
public class CollectionInterface {
    /**
     * calculates time adding collection.
     * @param collection - Collection<String>
     * @param line - string add
     * @param amount - amount
     * @return - time
     */
    public long add(Collection<String> collection, String line, int amount) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            String text = String.valueOf(i);

            collection.add(line + text);
        }
        return System.currentTimeMillis() - startTime;
    }

    /**
     * calculates time removing collection.
     * @param collection - Collection<String>
     * @@param amount - amount
     * @return - time
     */
    public long delete(Collection<String> collection, int amount) {
        long startTime = System.currentTimeMillis();
        Iterator<String> iter = collection.iterator();
        for (int i = 0; iter.hasNext() && i < amount; i++) {
            iter.next();
            iter.remove();
        }
        return System.currentTimeMillis() - startTime;
    }
    /**
     * calculates time removing collection from the end.
     * @param amount - amount
     * @param collection - Collection<String>
     * @return - time
     */
    public long delete(int amount, ArrayList<String> collection) {
        long startTime = System.currentTimeMillis();
        ListIterator<String> listIterator = collection.listIterator();
        for (int i = 0; listIterator.hasPrevious() && i < amount; i++) {
            listIterator.previous();
            listIterator.remove();
        }
        return System.currentTimeMillis() - startTime;
    }
}
