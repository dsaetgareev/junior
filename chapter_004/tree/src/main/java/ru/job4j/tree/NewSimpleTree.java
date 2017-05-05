package ru.job4j.tree;

/**
 * interface NewSimpleTree<E extends Comparable<E>> extends Iterable<E>.
 * @param <E> - some type
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 03.05.2017
 */
public interface NewSimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * adds element child to parent.
     * @param parent - parent
     * @param child - new child
     * @return - boolean
     */
    boolean add(E parent, E child);
}
