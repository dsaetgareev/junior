package ru.job4j.simplearrayset;

import java.util.Comparator;

/**
 * class QuickSet<E> extends QuickSet<E> implements quick set.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 23.04.2017
 * @version 1.0
 * @param <E> - some type
 */
public class QuickSortingSet<E> extends QuickSet<E> {
    /**
     * comparator.
     */
    private Comparator<? super E> comparator;

    /**
     * constructor.
     */
    public QuickSortingSet() {
        super();
        this.comparator = null;
    }

    /**
     * constructor.
     * @param comparator - new comparator
     */
    public QuickSortingSet(Comparator<? super E> comparator) {
        super();
        this.comparator = comparator;
    }
    /**
     * adds new element.
     * @param e - new element
     */
    @Override
    public void add(E e) {
        if (super.size() == 0 || compare(e, super.getArraySet()[super.size() - 1]) > 0
                || compare(e, super.getArraySet()[0]) < 0) {
            if (super.size() == 0
                    || compare(e, super.getArraySet()[super.size() - 1]) > 0) {
                super.getArraySet()[super.size()] = e;
                super.sizeIter();
                super.increaseArray();
            }
            if (compare(e, super.getArraySet()[0]) < 0) {
                super.shiftCells(-1);
                super.getArraySet()[0] = e;
                super.sizeIter();
                super.increaseArray();
            }
        } else {
            int index = indexSearch(e);
            if (hasDuplicate(e, index)) {
                add(index, e);
                super.increaseArray();
            }
        }
    }
    /**
     * checks for availability duplicates.
     * @param e new element
     * @param index index
     * @return boolean
     */
    @Override
    public boolean hasDuplicate(E e, int index) {
        boolean result = true;
        if (e.equals(super.getArraySet()[index])) {
            result = false;
        }
        return result;
    }
    /**
     * Finds the index in which you want to insert.
     * @param e new element
     * @return index
     */
    @Override
    public int indexSearch(E e) {
        int result = 0;
        int index = 0;
        int first = 0;
        int last = super.size();

        do {
            index = (last - first) / 2 + first;

            if (compare(e, super.getArraySet()[index]) >= 0
                    && compare(e, super.getArraySet()[index + 1]) < 0) {
                result =  index;
                break;
            }
            if (compare(e, super.getArraySet()[index]) < 0) {
                last = index;
            }
            if (compare(e, super.getArraySet()[index]) > 0) {
                first = index;
            }
        } while (true);
        return result;
    }

    /**
     * compare for comparator.
     * @param e1 - 1 element
     * @param e2 - 2 element
     * @return int
     */
    @SuppressWarnings("unchecked")
    private int compare(Object e1, Object e2) {
        return comparator == null ? ((Comparable<? super E>) e1).compareTo((E) e2)
                : comparator.compare((E) e1, (E) e2);
    }
}
