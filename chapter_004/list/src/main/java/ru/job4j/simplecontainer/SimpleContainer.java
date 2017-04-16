package ru.job4j.simplecontainer;

/**
 * interface SimpleContainer extends Iterable<E> is container.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 16.04.2017
 * @version 1.0
 * @param <E> - some type
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * adds new element.
     * @param e -new element
     */
    void add(E e);

    /**
     * return size.
     * @return - size
     */
    int size();

    /**
     * return this element.
     * @param index - index of element
     * @return e - element
     */
    E get(int index);

    /**
     * remove this element.
     * @param index - index of element
     */
    void remove(int index);
}
